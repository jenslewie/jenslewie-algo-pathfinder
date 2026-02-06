#!/usr/bin/env python3
import argparse
import pathlib
import re


def find_line_index(lines, pattern):
    for i, line in enumerate(lines):
        if re.search(pattern, line):
            return i
    return None


def section_lines(lines, start_idx, end_idx):
    return [line for line in lines[start_idx:end_idx] if line.strip()]


def has_br_suffix(line: str) -> bool:
    return re.search(r'<br>\s*$', line) is not None


def validate_bullet_lines(section_name, bullet_lines, errors):
    if not bullet_lines:
        errors.append(f'{section_name}: missing bullet explanation line(s).')
        return
    for i, line in enumerate(bullet_lines):
        has_br = has_br_suffix(line)
        if i < len(bullet_lines) - 1 and not has_br:
            errors.append(f'{section_name}: bullet line {i + 1} should end with <br>.')
        if i == len(bullet_lines) - 1 and has_br:
            errors.append(f'{section_name}: last bullet line should not end with <br>.')


def validate_section(section_name, section, errors, require_big_o=False):
    if not section:
        errors.append(f'{section_name}: section missing.')
        return
    header = section[0]
    if not has_br_suffix(header):
        errors.append(f'{section_name}: header should end with <br>.')
    if require_big_o and not re.search(r'O\([^)]*\)', header):
        errors.append(f'{section_name}: header should include Big-O like O(n).')

    bullet_lines = [line for line in section[1:] if line.strip().startswith('* -')]
    other_lines = [
        line for line in section[1:]
        if line not in bullet_lines
        and line.strip() not in ('', '* <p>')
    ]
    if other_lines:
        errors.append(f'{section_name}: non-bullet lines found after header.')
    validate_bullet_lines(section_name, bullet_lines, errors)


def main():
    parser = argparse.ArgumentParser(description='Validate class-level JavaDoc formatting for LeetFlow')
    parser.add_argument('--class', dest='class_name', required=True)
    parser.add_argument('--scope', choices=['global', 'lcr'], required=True)
    parser.add_argument('--repo-root', default='.')
    args = parser.parse_args()

    repo_root = pathlib.Path(args.repo_root)
    class_file = repo_root / 'algorithm/src/main/java/org/example/leetcode' / args.scope / f'{args.class_name}.java'
    if not class_file.exists():
        raise SystemExit(f'Class file not found: {class_file}')

    text = class_file.read_text()
    javadoc_match = re.search(r'/\*\*(?:.|\n)*?\*/', text)
    if not javadoc_match:
        raise SystemExit('Class-level JavaDoc not found.')

    javadoc_lines = javadoc_match.group(0).splitlines()
    errors = []

    link_idx = find_line_index(javadoc_lines, r'href=')
    diff_idx = find_line_index(javadoc_lines, r'Difficulty:')
    approach_idx = find_line_index(javadoc_lines, r'Approach:')
    time_idx = find_line_index(javadoc_lines, r'Time Complexity:')
    space_idx = find_line_index(javadoc_lines, r'Space Complexity:')

    if link_idx is None:
        errors.append('Missing problem link line with href.')
    else:
        link_line = javadoc_lines[link_idx]
        if args.scope == 'global':
            if 'https://leetcode.com/problems/' not in link_line:
                errors.append('Global link should use https://leetcode.com/problems/<slug>.')
            if '/description' in link_line:
                errors.append('Link should not include /description.')
        if args.scope == 'lcr' and 'href=""' in link_line and '></a>' in link_line:
            pass

    if diff_idx is None:
        errors.append('Missing Difficulty line.')
    else:
        diff_line = javadoc_lines[diff_idx]
        if args.scope == 'global' and 'Unknown' in diff_line:
            errors.append('Global difficulty should not be Unknown.')

    if link_idx is not None and diff_idx is not None and args.scope == 'global':
        description_lines = [
            line for line in javadoc_lines[link_idx + 1:diff_idx]
            if line.strip() and line.strip() != '* <p>'
        ]
        if not description_lines:
            errors.append('Global description block is missing.')

    if None in (approach_idx, time_idx, space_idx):
        errors.append('Missing required section(s): Approach, Time Complexity, Space Complexity.')
    else:
        if not (approach_idx < time_idx < space_idx):
            errors.append('Sections should be ordered: Approach -> Time Complexity -> Space Complexity.')

        approach_section = section_lines(javadoc_lines, approach_idx, time_idx)
        time_section = section_lines(javadoc_lines, time_idx, space_idx)
        space_section = section_lines(javadoc_lines, space_idx, len(javadoc_lines) - 1)

        validate_section('Approach', approach_section, errors, require_big_o=False)
        validate_section('Time Complexity', time_section, errors, require_big_o=True)
        validate_section('Space Complexity', space_section, errors, require_big_o=True)

    if errors:
        for err in errors:
            print(f'ERROR: {err}')
        raise SystemExit(1)

    print('JavaDoc validation passed.')


if __name__ == '__main__':
    main()
