#!/usr/bin/env python3
import argparse
import pathlib
import re


SCOPE_RE = re.compile(r'^##\s+(Global|LCR)\s*$')
SECTION_RE = re.compile(r'^(Easy|Medium|Hard)\s+\((\d+)\)$')


def finalize_section(errors, scope, difficulty, declared, actual):
    if difficulty is None:
        return
    if declared != actual:
        scope_label = scope or 'Unknown'
        errors.append(f'{scope_label} {difficulty} count mismatch: declared {declared}, actual {actual}.')


def main():
    parser = argparse.ArgumentParser(description='Validate README_DIFFICULTY.md counts match entries')
    parser.add_argument('--repo-root', default='.')
    args = parser.parse_args()

    readme_path = pathlib.Path(args.repo_root) / 'algorithm/README_DIFFICULTY.md'
    if not readme_path.exists():
        raise SystemExit(f'File not found: {readme_path}')

    lines = readme_path.read_text().splitlines()
    errors = []

    section_indices = []
    scope_indices = []
    for idx, raw in enumerate(lines):
        line = raw.strip()
        if SCOPE_RE.match(line):
            scope_indices.append(idx)
        if line.startswith('### '):
            section_indices.append(idx)

    if not section_indices:
        raise SystemExit('No section headers found in README_DIFFICULTY.md')

    for i, start in enumerate(section_indices):
        end = section_indices[i + 1] if i + 1 < len(section_indices) else len(lines)
        section_line = lines[start].strip()
        header = section_line.replace('### ', '', 1).strip()
        section_match = SECTION_RE.match(header)
        if not section_match:
            continue
        difficulty = section_match.group(1)
        declared = int(section_match.group(2))

        scope = None
        for s_idx in reversed(scope_indices):
            if s_idx < start:
                scope = SCOPE_RE.match(lines[s_idx].strip()).group(1)
                break
        scope_label = scope or 'Unknown'

        actual = sum(1 for raw in lines[start:end] if raw.lstrip().startswith('- '))
        if declared != actual:
            errors.append(f'{scope_label} {difficulty} count mismatch: declared {declared}, actual {actual}.')

    if errors:
        for err in errors:
            print(f'ERROR: {err}')
        raise SystemExit(1)

    print('README difficulty counts validation passed.')


if __name__ == '__main__':
    main()
