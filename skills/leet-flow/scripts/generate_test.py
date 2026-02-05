#!/usr/bin/env python3
import argparse
import pathlib
import re


def base_test_name(class_name: str, scope: str) -> str:
    if scope == 'global':
        m = re.match(r'LeetCode(\d+)', class_name)
        if not m:
            raise SystemExit('Expected class name like LeetCodeXXXX or LeetCodeXXXX_N')
        return f"LeetCode{m.group(1)}Test"
    if scope == 'lcr':
        m = re.match(r'LCR(\d+)', class_name)
        if not m:
            raise SystemExit('Expected class name like LCRXXXX or LCRXXXX_N')
        return f"LCR{m.group(1)}Test"
    raise SystemExit('scope must be global or lcr')


def main():
    parser = argparse.ArgumentParser(description='Generate a test class skeleton with labeled sections')
    parser.add_argument('--class', dest='class_name', required=True, help='Class name, e.g. LeetCode0123_1')
    parser.add_argument('--scope', choices=['global', 'lcr'], required=True)
    parser.add_argument('--repo-root', default='.', help='Repo root (default: .)')
    args = parser.parse_args()

    repo_root = pathlib.Path(args.repo_root)
    test_dir = repo_root / 'algorithm/src/test/java/org/example/leetcode' / args.scope
    test_dir.mkdir(parents=True, exist_ok=True)

    test_class = base_test_name(args.class_name, args.scope)
    test_file = test_dir / f'{test_class}.java'

    if test_file.exists():
        print(f'Test file already exists: {test_file}')
        return

    title_prefix = 'LeetCode' if args.scope == 'global' else 'LCR'
    display_name = f"{title_prefix} ???? : TODO"

    template = f"""package org.example.leetcode.{args.scope};

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(\"{display_name}\")
class {test_class} {{

    // TODO: instantiate solution class(es) using numeric suffixes, e.g. SOLUTION_1

    @FunctionalInterface
    interface SolutionFunction {{
        Object apply(Object input);
    }}

    // TODO: define ALGO_VARIANTS Map like LeetCode0003Test
    // For tree algorithms, use keys like dfs_recursive_traverse_with_stack
    // If metadata is included, prefix it with with_
    // following [dfs/bfs]_[recursive/iterative]_[traverse/divide_conquer]_[with_metadata]
    // private static final Map<String, SolutionFunction> ALGO_VARIANTS = Map.of(
    //         \"variant_1\", SOLUTION_1::methodName,
    //         \"variant_2\", SOLUTION_2::methodName
    // );

    @ParameterizedTest(name = \"[{{index}}] case={{0}}, algo={{1}}\")
    @MethodSource(\"allCombinations\")
    void testCases(String caseName, String algoName, Object input, Object expected) {{
        // TODO: build inputs and call solution
        // Object actual = ALGO_VARIANTS.get(algoName).apply(input);
        // assertEquals(expected, actual);
        assertEquals(expected, input);
    }}

    private static Stream<Arguments> allCombinations() {{
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }}

    private static Stream<TestCase> testCases() {{
        return Stream.of(
                // === LeetCode Official Examples ===
                // TODO: add official examples first

                // === Additional Coverage ===
                new TestCase(\"empty\", null, null)
        );
    }}

    private record TestCase(String name, Object input, Object expected) {{
    }}
}
"""

    test_file.write_text(template)
    print(f'Created {test_file}')


if __name__ == '__main__':
    main()
