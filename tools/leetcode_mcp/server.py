#!/usr/bin/env python3
"""Minimal MCP server for LeetCode metadata queries.

Tools:
- get_global_problem(frontend_id)
- get_lcr_problem(lcr_id)
- to_javadoc_description(content, mode)
"""

from __future__ import annotations

import datetime as dt
import html
import json
import os
import re
import sys
import urllib.error
import urllib.request
from pathlib import Path
from typing import Any

SERVER_NAME = "leetcode-mcp"
SERVER_VERSION = "0.1.0"
DEFAULT_PROTOCOL_VERSION = "2024-11-05"

GLOBAL_ENDPOINT = "https://leetcode.com/graphql"
CN_ENDPOINT = "https://leetcode.cn/graphql/"


def _cache_path() -> Path:
    env_path = os.getenv("LEETCODE_MCP_CACHE_PATH")
    if env_path:
        return Path(env_path).expanduser()
    return Path.home() / ".cache" / "leetcode-mcp" / "cache.json"


class CacheStore:
    def __init__(self, path: Path) -> None:
        self.path = path
        self.data: dict[str, Any] = {}
        self._load()

    def _load(self) -> None:
        try:
            if self.path.exists():
                self.data = json.loads(self.path.read_text(encoding="utf-8"))
            else:
                self.data = {}
        except Exception:
            self.data = {}

    def get(self, key: str) -> Any | None:
        return self.data.get(key)

    def set(self, key: str, value: Any) -> None:
        self.data[key] = value
        self.path.parent.mkdir(parents=True, exist_ok=True)
        self.path.write_text(json.dumps(self.data, ensure_ascii=False, indent=2), encoding="utf-8")


CACHE = CacheStore(_cache_path())


def _http_post_json(url: str, payload: dict[str, Any], *, cn: bool = False) -> dict[str, Any]:
    body = json.dumps(payload).encode("utf-8")
    headers = {
        "Content-Type": "application/json",
        "User-Agent": "leetcode-mcp/0.1",
    }
    if cn:
        headers.update({"Origin": "https://leetcode.cn", "Referer": "https://leetcode.cn/problemset/"})

    req = urllib.request.Request(url, data=body, method="POST", headers=headers)
    try:
        with urllib.request.urlopen(req, timeout=20) as resp:
            raw = resp.read().decode("utf-8")
            return json.loads(raw)
    except urllib.error.HTTPError as e:
        try:
            detail = e.read().decode("utf-8")
        except Exception:
            detail = str(e)
        raise RuntimeError(f"HTTP {e.code}: {detail}") from e
    except urllib.error.URLError as e:
        raise RuntimeError(f"Network error: {e}") from e


def _normalize_frontend_id(frontend_id: str) -> str:
    m = re.search(r"(\d+)", str(frontend_id))
    if not m:
        raise ValueError("frontend_id must contain digits")
    return str(int(m.group(1)))


def _normalize_lcr_id(lcr_id: str) -> str:
    m = re.search(r"(\d+)", str(lcr_id))
    if not m:
        raise ValueError("lcr_id must contain digits")
    return f"LCR {int(m.group(1))}"


def _global_search(frontend_id: str) -> dict[str, Any]:
    query = (
        "query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {"
        " problemsetQuestionList: questionList(categorySlug: $categorySlug, limit: $limit, skip: $skip, filters: $filters) {"
        " questions: data { frontendQuestionId: questionFrontendId title titleSlug difficulty } } }"
    )
    payload = {
        "query": query,
        "variables": {
            "categorySlug": "",
            "skip": 0,
            "limit": 20,
            "filters": {"searchKeywords": frontend_id},
        },
    }
    data = _http_post_json(GLOBAL_ENDPOINT, payload)
    questions = data.get("data", {}).get("problemsetQuestionList", {}).get("questions", [])
    target = None
    for q in questions:
        q_id = str(q.get("frontendQuestionId", "")).strip()
        if q_id and str(int(q_id)) == frontend_id:
            target = q
            break
    if target is None and questions:
        target = questions[0]
    if not target:
        raise RuntimeError(f"No global problem found for id={frontend_id}")
    return target


def _global_question_by_slug(slug: str) -> dict[str, Any]:
    query = (
        "query questionData($titleSlug: String!) {"
        " question(titleSlug: $titleSlug) {"
        " questionFrontendId title titleSlug difficulty content"
        " }"
        "}"
    )
    payload = {"query": query, "variables": {"titleSlug": slug}}
    data = _http_post_json(GLOBAL_ENDPOINT, payload)
    question = data.get("data", {}).get("question")
    if not question:
        raise RuntimeError(f"No question payload returned for slug={slug}")
    return question


def _lcr_search(lcr_id: str) -> dict[str, Any]:
    query = (
        "query problemsetPanelQuestionList($filters: QuestionFilterInput, $searchKeyword: String, $sortBy: QuestionSortByInput, $categorySlug: String, $limit: Int, $skip: Int) {"
        " problemsetPanelQuestionList(filters: $filters, searchKeyword: $searchKeyword, sortBy: $sortBy, categorySlug: $categorySlug, limit: $limit, skip: $skip) {"
        " questions { id titleSlug title translatedTitle questionFrontendId paidOnly difficulty } totalLength hasMore } }"
    )
    payload = {
        "operationName": "problemsetPanelQuestionList",
        "query": query,
        "variables": {
            "skip": 0,
            "limit": 100,
            "categorySlug": "",
            "searchKeyword": lcr_id,
            "sortBy": {"sortField": "CUSTOM", "sortOrder": "ASCENDING"},
            "filters": {
                "filterCombineType": "ALL",
                "statusFilter": {"questionStatuses": [], "operator": "IS"},
                "difficultyFilter": {"difficulties": [], "operator": "IS"},
                "languageFilter": {"languageSlugs": [], "operator": "IS"},
                "topicFilter": {"topicSlugs": [], "operator": "IS"},
                "acceptanceFilter": {},
                "frequencyFilter": {},
                "frontendIdFilter": {},
                "lastSubmittedFilter": {},
                "publishedFilter": {},
                "companyFilter": {"companySlugs": [], "operator": "IS"},
                "positionFilter": {"positionSlugs": [], "operator": "IS"},
                "positionLevelFilter": {"positionLevelSlugs": [], "operator": "IS"},
                "contestPointFilter": {"contestPoints": [], "operator": "IS"},
                "premiumFilter": {"premiumStatus": [], "operator": "IS"},
            },
            "options": {"enabled": True},
        },
    }
    data = _http_post_json(CN_ENDPOINT, payload, cn=True)
    questions = data.get("data", {}).get("problemsetPanelQuestionList", {}).get("questions", [])
    target = None
    for q in questions:
        if str(q.get("questionFrontendId", "")).strip().upper() == lcr_id.upper():
            target = q
            break
    if target is None and questions:
        target = questions[0]
    if not target:
        raise RuntimeError(f"No LCR problem found for id={lcr_id}")
    return target


def _cn_question_by_slug(slug: str) -> dict[str, Any]:
    query = (
        "query questionData($titleSlug: String!) {"
        " question(titleSlug: $titleSlug) {"
        " questionFrontendId title translatedTitle titleSlug difficulty content translatedContent"
        " }"
        "}"
    )
    payload = {
        "operationName": "questionData",
        "query": query,
        "variables": {"titleSlug": slug},
    }
    data = _http_post_json(CN_ENDPOINT, payload, cn=True)
    question = data.get("data", {}).get("question")
    if not question:
        raise RuntimeError(f"No question payload returned for slug={slug}")
    return question


def html_to_lines(raw_html: str, mode: str = "normalized") -> list[str]:
    text = raw_html or ""
    text = text.replace("\r", "")
    text = re.sub(r"<br\s*/?>", "\n", text, flags=re.IGNORECASE)
    text = re.sub(r"</p\s*>", "\n", text, flags=re.IGNORECASE)
    text = re.sub(r"<p\s*>", "", text, flags=re.IGNORECASE)
    text = re.sub(r"</li\s*>", "\n", text, flags=re.IGNORECASE)
    text = re.sub(r"<li\s*>", "", text, flags=re.IGNORECASE)
    text = re.sub(r"</pre\s*>", "\n", text, flags=re.IGNORECASE)
    text = re.sub(r"<pre\s*>", "\n", text, flags=re.IGNORECASE)
    text = re.sub(r"<[^>]+>", "", text)
    text = html.unescape(text)
    text = text.replace("\xa0", " ")

    lines = [line.strip() for line in text.splitlines() if line.strip()]

    if mode == "normalized":
        stop_patterns = [
            r"^Example\s*\d*\s*:",
            r"^Constraints\s*:?$",
            r"^Follow up\s*:?$",
            r"^示例\s*\d*\s*[:：]?$",
            r"^提示\s*[:：]?$",
            r"^约束\s*[:：]?$",
        ]
        normalized: list[str] = []
        for line in lines:
            if any(re.search(p, line, flags=re.IGNORECASE) for p in stop_patterns):
                break
            normalized.append(line)
        lines = normalized

    return lines


def to_javadoc_lines(lines: list[str]) -> list[str]:
    if not lines:
        return []
    out = []
    for i, line in enumerate(lines):
        suffix = " <br>" if i < len(lines) - 1 else ""
        out.append(f"* {line}{suffix}")
    return out


def _tool_get_global_problem(args: dict[str, Any]) -> dict[str, Any]:
    frontend_id = _normalize_frontend_id(str(args.get("frontend_id", "")))
    cache_key = f"global:{frontend_id}"
    cached = CACHE.get(cache_key)
    if cached:
        return cached

    base = _global_search(frontend_id)
    detail = _global_question_by_slug(base["titleSlug"])
    content = detail.get("content") or ""
    lines = html_to_lines(content, mode="normalized")

    payload = {
        "source": "leetcode.com/graphql",
        "frontend_id": str(detail.get("questionFrontendId", frontend_id)),
        "title": detail.get("title", base.get("title")),
        "slug": detail.get("titleSlug", base.get("titleSlug")),
        "difficulty": detail.get("difficulty", base.get("difficulty")),
        "url": f"https://leetcode.com/problems/{detail.get('titleSlug', base.get('titleSlug'))}",
        "content_html": content,
        "description_lines": lines,
        "javadoc_lines": to_javadoc_lines(lines),
        "fetched_at": dt.datetime.now(dt.timezone.utc).isoformat(),
    }
    CACHE.set(cache_key, payload)
    return payload


def _tool_get_lcr_problem(args: dict[str, Any]) -> dict[str, Any]:
    lcr_id = _normalize_lcr_id(str(args.get("lcr_id", "")))
    cache_key = f"lcr:{lcr_id}"
    cached = CACHE.get(cache_key)
    if cached:
        return cached

    base = _lcr_search(lcr_id)
    detail = _cn_question_by_slug(base["titleSlug"])
    content = detail.get("translatedContent") or detail.get("content") or ""
    lines = html_to_lines(content, mode="normalized")

    payload = {
        "source": "leetcode.cn/graphql",
        "frontend_id": str(detail.get("questionFrontendId", lcr_id)),
        "title": detail.get("title", base.get("title")),
        "translated_title": detail.get("translatedTitle", base.get("translatedTitle")),
        "slug": detail.get("titleSlug", base.get("titleSlug")),
        "difficulty": detail.get("difficulty", base.get("difficulty")),
        "url": f"https://leetcode.cn/problems/{detail.get('titleSlug', base.get('titleSlug'))}",
        "content_html": content,
        "description_lines": lines,
        "javadoc_lines": to_javadoc_lines(lines),
        "fetched_at": dt.datetime.now(dt.timezone.utc).isoformat(),
    }
    CACHE.set(cache_key, payload)
    return payload


def _tool_to_javadoc_description(args: dict[str, Any]) -> dict[str, Any]:
    content = str(args.get("content", ""))
    mode = str(args.get("mode", "normalized")).strip().lower()
    if mode not in {"normalized", "literal"}:
        raise ValueError("mode must be 'normalized' or 'literal'")
    lines = html_to_lines(content, mode=mode)
    return {
        "mode": mode,
        "description_lines": lines,
        "javadoc_lines": to_javadoc_lines(lines),
    }


TOOLS = {
    "get_global_problem": {
        "description": "Fetch global LeetCode problem metadata/content by frontend id from leetcode.com/graphql.",
        "inputSchema": {
            "type": "object",
            "properties": {"frontend_id": {"type": "string", "description": "LeetCode frontend id, e.g. '4' or 'LeetCode0004'"}},
            "required": ["frontend_id"],
            "additionalProperties": False,
        },
        "handler": _tool_get_global_problem,
    },
    "get_lcr_problem": {
        "description": "Fetch LCR problem metadata/content by LCR id from leetcode.cn/graphql.",
        "inputSchema": {
            "type": "object",
            "properties": {"lcr_id": {"type": "string", "description": "LCR id, e.g. '180' or 'LCR 180'"}},
            "required": ["lcr_id"],
            "additionalProperties": False,
        },
        "handler": _tool_get_lcr_problem,
    },
    "to_javadoc_description": {
        "description": "Convert HTML content to JavaDoc-friendly description lines.",
        "inputSchema": {
            "type": "object",
            "properties": {
                "content": {"type": "string", "description": "HTML content string (content or translatedContent)"},
                "mode": {"type": "string", "enum": ["normalized", "literal"], "default": "normalized"},
            },
            "required": ["content"],
            "additionalProperties": False,
        },
        "handler": _tool_to_javadoc_description,
    },
}


def _result_text(payload: Any) -> dict[str, Any]:
    return {
        "content": [{"type": "text", "text": json.dumps(payload, ensure_ascii=False, indent=2)}],
    }


def _error_text(msg: str) -> dict[str, Any]:
    return {
        "isError": True,
        "content": [{"type": "text", "text": msg}],
    }


def handle_request(method: str, params: dict[str, Any]) -> dict[str, Any]:
    if method == "initialize":
        requested = params.get("protocolVersion")
        protocol = requested or DEFAULT_PROTOCOL_VERSION
        return {
            "protocolVersion": protocol,
            "capabilities": {"tools": {}},
            "serverInfo": {"name": SERVER_NAME, "version": SERVER_VERSION},
        }

    if method == "tools/list":
        return {
            "tools": [
                {
                    "name": name,
                    "description": spec["description"],
                    "inputSchema": spec["inputSchema"],
                }
                for name, spec in TOOLS.items()
            ]
        }

    if method == "tools/call":
        name = params.get("name")
        args = params.get("arguments", {})
        if name not in TOOLS:
            return _error_text(f"Unknown tool: {name}")
        try:
            payload = TOOLS[name]["handler"](args)
            return _result_text(payload)
        except Exception as exc:
            return _error_text(str(exc))

    if method == "ping":
        return {}

    raise NotImplementedError(method)


def read_message() -> dict[str, Any] | None:
    headers: dict[str, str] = {}
    while True:
        line = sys.stdin.buffer.readline()
        if not line:
            return None
        if line in (b"\r\n", b"\n"):
            break
        try:
            key, value = line.decode("utf-8").split(":", 1)
        except ValueError:
            continue
        headers[key.strip().lower()] = value.strip()

    content_length = int(headers.get("content-length", "0"))
    if content_length <= 0:
        return None

    body = sys.stdin.buffer.read(content_length)
    return json.loads(body.decode("utf-8"))


def send_message(payload: dict[str, Any]) -> None:
    body = json.dumps(payload, ensure_ascii=False).encode("utf-8")
    header = f"Content-Length: {len(body)}\r\n\r\n".encode("ascii")
    sys.stdout.buffer.write(header)
    sys.stdout.buffer.write(body)
    sys.stdout.buffer.flush()


def main() -> int:
    while True:
        msg = read_message()
        if msg is None:
            return 0

        method = msg.get("method")
        req_id = msg.get("id")
        params = msg.get("params", {})

        if not method:
            continue

        if req_id is None:
            # Notification; no response.
            continue

        try:
            result = handle_request(method, params)
            send_message({"jsonrpc": "2.0", "id": req_id, "result": result})
        except NotImplementedError:
            send_message(
                {
                    "jsonrpc": "2.0",
                    "id": req_id,
                    "error": {"code": -32601, "message": f"Method not found: {method}"},
                }
            )
        except Exception as exc:
            send_message(
                {
                    "jsonrpc": "2.0",
                    "id": req_id,
                    "error": {"code": -32000, "message": str(exc)},
                }
            )


if __name__ == "__main__":
    raise SystemExit(main())
