#!/usr/bin/env python3
import argparse
import pathlib
import re


def main():
    parser = argparse.ArgumentParser(description='Validate LeetFlow test style for a solution class')
    parser.add_argument('--class', dest='class_name', required=True)
    parser.add_argument('--scope', choices=['global', 'lcr'], required=True)
    parser.add_argument('--repo-root', default='.')
    args = parser.parse_args()

    repo_root = pathlib.Path(args.repo_root)
    test_dir = repo_root / 'algorithm/src/test/java/org/example/leetcode' / args.scope

    if args.scope == 'global':
        m = re.match(r'LeetCode(\d+)', args.class_name)
        if not m:
            raise SystemExit('Expected class name like LeetCodeXXXX or LeetCodeXXXX_N')
        test_class = f'LeetCode{m.group(1)}Test'
    else:
        m = re.match(r'LCR(\d+)', args.class_name)
        if not m:
            raise SystemExit('Expected class name like LCRXXXX or LCRXXXX_N')
        test_class = f'LCR{m.group(1)}Test'

    test_file = test_dir / f'{test_class}.java'
    if not test_file.exists():
        raise SystemExit(f'Test file not found: {test_file}')

    text = test_file.read_text()
    errors = []

    if 'ALGO_VARIANTS' not in text:
        errors.append('Missing ALGO_VARIANTS Map for variant dispatch.')
    if 'ALGO_VARIANTS.keySet()' not in text:
        errors.append('allCombinations should iterate ALGO_VARIANTS.keySet().')
    if 'ALGO_VARIANTS.get' not in text:
        errors.append('Test method should call ALGO_VARIANTS.get(algoName).')
    if 'allCombinations' not in text:
        errors.append('Missing allCombinations method.')
    if '@ParameterizedTest' not in text:
        errors.append('Missing @ParameterizedTest annotation.')
    if 'MethodSource("allCombinations")' not in text:
        errors.append('Parameterized test should use MethodSource("allCombinations").')
    if 'testCases()' not in text:
        errors.append('Missing testCases() helper with labeled sections.')
    if 'LeetCode Official Examples' not in text:
        errors.append('Missing "LeetCode Official Examples" section label.')
    if 'Additional Coverage' not in text:
        errors.append('Missing "Additional Coverage" section label.')
    if not re.search(r'SOLUTION_\d+', text):
        errors.append('Missing SOLUTION_<n> variables for solution instances.')
    if '@FunctionalInterface' not in text:
        errors.append('Missing @FunctionalInterface for variant mapping.')
    else:
        iface_match = re.search(r'@FunctionalInterface\s+interface\s+(\w+)', text, re.S)
        if iface_match:
            iface_name = iface_match.group(1)
            if f'<String, {iface_name}>' not in text:
                errors.append('ALGO_VARIANTS should be typed to the declared @FunctionalInterface.')

    if '@ParameterizedTest' in text:
        name_match = re.search(r'@ParameterizedTest\(\s*name\s*=\s*"([^"]+)"\s*\)', text)
        if not name_match:
            errors.append('Parameterized test should include a name attribute.')
        else:
            name_value = name_match.group(1)
            if '{index}' not in name_value or 'case={0}' not in name_value or 'algo={1}' not in name_value:
                errors.append('Parameterized test name must include \"[{index}] case={0}, algo={1}\" (additional placeholders allowed).')

    order_markers = {
        'SOLUTION': text.find('SOLUTION_'),
        'FunctionalInterface': text.find('@FunctionalInterface'),
        'ALGO_VARIANTS': text.find('ALGO_VARIANTS'),
        'ParameterizedTest': text.find('@ParameterizedTest'),
        'allCombinations': text.find('allCombinations'),
        'testCases': text.find('testCases'),
    }
    if all(v != -1 for v in order_markers.values()):
        if not (order_markers['SOLUTION'] < order_markers['FunctionalInterface'] < order_markers['ALGO_VARIANTS']
                < order_markers['ParameterizedTest'] < order_markers['allCombinations'] < order_markers['testCases']):
            errors.append('Test file order should be: SOLUTION fields, @FunctionalInterface, ALGO_VARIANTS, @ParameterizedTest, allCombinations, testCases, TestCase record (if present).')

    per_solution_tests = re.findall(r'@DisplayName\\(\"Solution\\s+\\d+\\s+Test\"\\)', text)
    if per_solution_tests:
        errors.append('Do not create per-solution test methods; use a single variant-dispatched test.')

    if errors:
        for err in errors:
            print(f'ERROR: {err}')
        raise SystemExit(1)

    print('Test style validation passed.')


if __name__ == '__main__':
    main()
