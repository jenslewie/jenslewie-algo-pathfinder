#!/usr/bin/env python3
import argparse
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

    if args.scope == 'global':
        m = re.search(r'LeetCode(\d+)', args.class_name)
        if not m:
            raise SystemExit('Unable to extract frontend id from class name.')
        frontend_id = m.group(1).lstrip('0') or '0'
        entry = load_global_entry(repo_root / args.json_path, frontend_id)
        if not entry:
            raise SystemExit(f'Problem {frontend_id} not found in JSON.')
        title = entry.get('title', '').strip()
        slug = entry.get('problem_slug', '').strip()
        difficulty = entry.get('difficulty', '').strip()
        description = entry.get('description', '').strip()
        if not (title and slug and difficulty and description):
            raise SystemExit('Missing required fields in JSON entry.')
        link_line = f' * <a href="https://leetcode.com/problems/{slug}">LeetCode {int(frontend_id)}: {title}</a>'
        desc_lines = html_to_lines(description)
        difficulty_line = f' * Difficulty: {difficulty}'
    else:
        # LCR: keep existing if not provided
        link_line = existing_link_line(javadoc_lines)
        link_idx = next((i for i, l in enumerate(javadoc_lines) if l == link_line), None) if link_line else None
        diff_idx = next((i for i, l in enumerate(javadoc_lines) if 'Difficulty:' in l), None)

        if args.link or args.title:
            title = args.title
            link = args.link
            link_line = f' * <a href="{link}">{title}</a>'
        elif link_line is None:
            link_line = ' * <a href=""></a>'

        if args.description:
            desc_lines = [args.description]
        else:
            desc_lines = existing_description_lines(javadoc_lines, link_idx, diff_idx)

        difficulty = args.difficulty if args.difficulty else 'Unknown'
        difficulty_line = f' * Difficulty: {difficulty}'

    new_javadoc = build_javadoc(link_line, desc_lines, difficulty_line, approach_block)
    class_file.write_text(text.replace(javadoc_block, new_javadoc))


if __name__ == '__main__':
    main()
