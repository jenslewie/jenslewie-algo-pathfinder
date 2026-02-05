#!/usr/bin/env python3
import argparse
import json
import pathlib
import re
from collections import defaultdict


def load_global_ids(root: pathlib.Path):
    ids = set()
    for p in (root / 'algorithm/src/main/java/org/example/leetcode/global').glob('*.java'):
        m = re.search(r'LeetCode(\d+)', p.stem)
        if m:
            ids.add(int(m.group(1)))
    return ids


def load_lcr_items(root: pathlib.Path):
    items = {}
    lcr_dir = root / 'algorithm/src/main/java/org/example/leetcode/lcr'
    for p in lcr_dir.glob('*.java'):
        name = p.stem
        base_id = re.sub(r'_\d+$', '', name)
        text = p.read_text()
        title = ''
        m_title = re.search(r'>\s*LCR\s+\d+\s*:\s*(.*?)</a>', text)
        if m_title:
            title = m_title.group(1).strip()
        m_diff = re.search(r'Difficulty:\s*(Easy|Medium|Hard|Unknown)', text)
        diff = m_diff.group(1) if m_diff else 'Unknown'
        if base_id not in items:
            items[base_id] = (title, diff)
    return items


def main():
    parser = argparse.ArgumentParser(description='Regenerate algorithm/README_DIFFICULTY.md')
    parser.add_argument('--repo-root', default='.', help='Repo root (default: .)')
    parser.add_argument('--json', default='algorithm/src/main/resources/merged_problems.json')
    args = parser.parse_args()

    root = pathlib.Path(args.repo_root)
    json_path = root / args.json

    with json_path.open() as f:
        data = json.load(f)

    by_id = {}
    for q in data.get('questions', []):
        fid = q.get('frontend_id')
        if not fid:
            continue
        try:
            fid_int = int(fid)
        except ValueError:
            continue
        by_id[fid_int] = q

    ids_global = load_global_ids(root)
    lcr_items = load_lcr_items(root)

    order = ['Easy', 'Medium', 'Hard', 'Unknown']

    # Global
    by_diff_global = defaultdict(list)
    for fid in sorted(ids_global):
        q = by_id.get(fid)
        if not q:
            continue
        title = q.get('title', '').strip()
        diff = q.get('difficulty', 'Unknown').strip() or 'Unknown'
        by_diff_global[diff].append((fid, title))

    # LCR
    by_diff_lcr = defaultdict(list)
    for base_id, (title, diff) in lcr_items.items():
        by_diff_lcr[diff].append((base_id, title))
    for diff in by_diff_lcr:
        by_diff_lcr[diff].sort(key=lambda x: x[0])

    lines = []
    lines.append('# LeetCode Difficulty Index')
    lines.append('')
    lines.append('This index covers classes in `org.example.leetcode.global` and `org.example.leetcode.lcr`.')
    lines.append('')

    lines.append('## Global')
    for diff in order:
        items = by_diff_global.get(diff, [])
        if not items:
            continue
        lines.append(f'### {diff} ({len(items)})')
        for fid, title in items:
            lines.append(f'- LeetCode{fid:04d} - {title}')
        lines.append('')

    lines.append('## LCR')
    for diff in order:
        items = by_diff_lcr.get(diff, [])
        if not items:
            continue
        lines.append(f'### {diff} ({len(items)})')
        for base_id, title in items:
            lines.append(f'- {base_id} - {title}')
        lines.append('')

    out_path = root / 'algorithm/README_DIFFICULTY.md'
    out_path.write_text('\n'.join(lines))


if __name__ == '__main__':
    main()
