#!/usr/bin/env python3
import argparse
import importlib.util
import json
import pathlib
import re
from html import unescape


def html_to_lines(html: str):
    s = html.replace('\r', '')
    s = re.sub(r'<br\s*/?>', '\n', s, flags=re.I)
    s = re.sub(r'</p\s*>', '\n', s, flags=re.I)
    s = re.sub(r'<p\s*>', '', s, flags=re.I)
    s = re.sub(r'</li\s*>', '\n', s, flags=re.I)
    s = re.sub(r'<li\s*>', '- ', s, flags=re.I)
    s = re.sub(r'<[^>]+>', '', s)
    s = unescape(s)
    lines = [line.strip() for line in s.splitlines()]
    lines = [line for line in lines if line]
    cleaned = []
    for line in lines:
        if re.fullmatch(r'Example\s*\d+:', line):
            continue
        if line == 'Constraints:':
            continue
        cleaned.append(line)
    return cleaned


def load_global_entry(json_path: pathlib.Path, frontend_id: str):
    with json_path.open() as f:
        data = json.load(f)
    for q in data.get('questions', []):
        if q.get('frontend_id') == frontend_id:
            return q
    return None


def load_mcp_module(repo_root: pathlib.Path):
    server_path = repo_root / 'tools/leetcode_mcp/server.py'
    if not server_path.exists():
        return None
    spec = importlib.util.spec_from_file_location('leetcode_mcp_server', server_path)
    if spec is None or spec.loader is None:
        return None
    module = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(module)
    return module


def normalize_difficulty(value: str):
    if not value:
        return ''
    lowered = value.strip().lower()
    mapping = {
        'easy': 'Easy',
        'medium': 'Medium',
        'hard': 'Hard',
        'unknown': 'Unknown',
    }
    return mapping.get(lowered, value.strip())


def fetch_global_entry_via_mcp(mcp_module, frontend_id: str):
    payload = mcp_module._tool_get_global_problem({'frontend_id': frontend_id})
    title = str(payload.get('title', '')).strip()
    slug = str(payload.get('slug', '')).strip()
    difficulty = normalize_difficulty(str(payload.get('difficulty', '')).strip())
    lines = payload.get('description_lines', [])
    if not (title and slug and difficulty and isinstance(lines, list) and lines):
        raise ValueError('MCP response missing required global metadata.')
    return {
        'title': title,
        'slug': slug,
        'difficulty': difficulty,
        'description_lines': [str(line).strip() for line in lines if str(line).strip()],
    }


def fetch_lcr_entry_via_mcp(mcp_module, lcr_id: str):
    payload = mcp_module._tool_get_lcr_problem({'lcr_id': lcr_id})
    frontend_id = str(payload.get('frontend_id', f'LCR {int(lcr_id)}')).strip()
    title = str(payload.get('translated_title') or payload.get('title') or '').strip()
    url = str(payload.get('url', '')).strip()
    difficulty = normalize_difficulty(str(payload.get('difficulty', '')).strip()) or 'Unknown'
    lines = payload.get('description_lines', [])
    if not (url and isinstance(lines, list) and lines):
        raise ValueError('MCP response missing required LCR metadata.')
    if title:
        link_line = f' * <a href="{url}">{frontend_id}: {title}</a>'
    else:
        link_line = f' * <a href="{url}">{frontend_id}</a>'
    return {
        'link_line': link_line,
        'difficulty': difficulty,
        'description_lines': [str(line).strip() for line in lines if str(line).strip()],
    }


def build_javadoc(link_line, desc_lines, difficulty_line, approach_block):
    lines = ['/**', link_line]
    if desc_lines:
        lines.append(' * <p>')
        for i, line in enumerate(desc_lines):
            suffix = ' <br>' if i < len(desc_lines) - 1 else ''
            lines.append(f' * {line}{suffix}')
    lines.append(' * <p>')
    lines.append(difficulty_line)
    lines.append(' * <p>')
    lines.extend(approach_block)
    lines.append(' */')
    return '\n'.join(lines)


def extract_approach_block(javadoc_lines):
    idx = next((i for i, l in enumerate(javadoc_lines) if 'Approach:' in l), None)
    if idx is None:
        return None
    block = javadoc_lines[idx:-1]
    # normalize leading
    normalized = []
    for l in block:
        if l.startswith(' *'):
            normalized.append(l)
        else:
            normalized.append(' * ' + l.lstrip())
    # drop leading <p>
    while normalized and normalized[0].strip() == '* <p>':
        normalized = normalized[1:]
    return normalized


def existing_link_line(javadoc_lines):
    for l in javadoc_lines:
        if 'href=' in l:
            return l
    return None


def existing_description_lines(javadoc_lines, link_idx, diff_idx):
    if link_idx is None or diff_idx is None:
        return []
    lines = []
    for l in javadoc_lines[link_idx + 1: diff_idx]:
        if l.strip() == '* <p>' or not l.strip():
            continue
        lines.append(l)
    return lines


def main():
    parser = argparse.ArgumentParser(description='Update class-level JavaDoc for LeetCode/LCR solutions')
    parser.add_argument('--class', dest='class_name', required=True, help='Class name, e.g. LeetCode0235_1 or LCR0014_1')
    parser.add_argument('--scope', choices=['global', 'lcr'], required=True)
    parser.add_argument('--repo-root', default='.', help='Repo root (default: .)')
    parser.add_argument('--json', dest='json_path', default='algorithm/src/main/resources/merged_problems.json')
    parser.add_argument('--link', default='', help='Optional link override (LCR)')
    parser.add_argument('--title', default='', help='Optional title override (LCR)')
    parser.add_argument('--description', default='', help='Optional description override (LCR)')
    parser.add_argument('--difficulty', default='', help='Optional difficulty override (LCR)')
    args = parser.parse_args()

    repo_root = pathlib.Path(args.repo_root)
    scope_dir = repo_root / 'algorithm/src/main/java/org/example/leetcode' / args.scope
    class_file = scope_dir / f'{args.class_name}.java'
    if not class_file.exists():
        raise SystemExit(f'Class file not found: {class_file}')

    text = class_file.read_text()
    javadoc_match = re.search(r'/\*\*(?:.|\n)*?\*/\s*(public\s+)?class\s+', text)
    if not javadoc_match:
        raise SystemExit('Class-level JavaDoc not found.')
    javadoc_block = re.search(r'/\*\*(?:.|\n)*?\*/', text).group(0)
    javadoc_lines = javadoc_block.splitlines()

    approach_block = extract_approach_block(javadoc_lines)
    if approach_block is None:
        raise SystemExit('Approach section not found in JavaDoc.')

    mcp_module = load_mcp_module(repo_root)

    if args.scope == 'global':
        m = re.search(r'LeetCode(\d+)', args.class_name)
        if not m:
            raise SystemExit('Unable to extract frontend id from class name.')
        frontend_id = m.group(1).lstrip('0') or '0'
        mcp_entry = None
        if mcp_module is not None:
            try:
                mcp_entry = fetch_global_entry_via_mcp(mcp_module, frontend_id)
            except Exception:
                mcp_entry = None

        if mcp_entry is not None:
            title = mcp_entry['title']
            slug = mcp_entry['slug']
            difficulty = mcp_entry['difficulty']
            desc_lines = mcp_entry['description_lines']
        else:
            entry = load_global_entry(repo_root / args.json_path, frontend_id)
            if not entry:
                raise SystemExit(f'Problem {frontend_id} not found in JSON.')
            title = entry.get('title', '').strip()
            slug = entry.get('problem_slug', '').strip()
            difficulty = entry.get('difficulty', '').strip()
            description = entry.get('description', '').strip()
            if not (title and slug and difficulty and description):
                raise SystemExit('Missing required fields in JSON entry.')
            desc_lines = html_to_lines(description)

        link_line = f' * <a href="https://leetcode.com/problems/{slug}">LeetCode {int(frontend_id)}: {title}</a>'
        difficulty_line = f' * Difficulty: {difficulty}'
    else:
        # LCR: keep existing if not provided
        link_line = existing_link_line(javadoc_lines)
        link_idx = next((i for i, l in enumerate(javadoc_lines) if l == link_line), None) if link_line else None
        diff_idx = next((i for i, l in enumerate(javadoc_lines) if 'Difficulty:' in l), None)
        lcr_mcp_entry = None
        if args.link == '' and args.title == '' and args.description == '' and args.difficulty == '':
            m = re.search(r'LCR(\d+)', args.class_name)
            if m and mcp_module is not None:
                try:
                    lcr_mcp_entry = fetch_lcr_entry_via_mcp(mcp_module, m.group(1))
                except Exception:
                    lcr_mcp_entry = None

        if args.link or args.title:
            title = args.title
            link = args.link
            link_line = f' * <a href="{link}">{title}</a>'
        elif lcr_mcp_entry is not None:
            link_line = lcr_mcp_entry['link_line']
        elif link_line is None:
            link_line = ' * <a href=""></a>'

        if args.description:
            desc_lines = [args.description]
        elif lcr_mcp_entry is not None:
            desc_lines = lcr_mcp_entry['description_lines']
        else:
            desc_lines = existing_description_lines(javadoc_lines, link_idx, diff_idx)

        if args.difficulty:
            difficulty = args.difficulty
        elif lcr_mcp_entry is not None:
            difficulty = lcr_mcp_entry['difficulty']
        else:
            difficulty = 'Unknown'
        difficulty_line = f' * Difficulty: {difficulty}'

    new_javadoc = build_javadoc(link_line, desc_lines, difficulty_line, approach_block)
    class_file.write_text(text.replace(javadoc_block, new_javadoc))


if __name__ == '__main__':
    main()
