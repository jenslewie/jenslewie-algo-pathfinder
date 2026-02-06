package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 257: Binary Tree Paths")
class LeetCode0257Test {

    private static final LeetCode0257_1 SOLUTION_1 = new LeetCode0257_1();
    private static final LeetCode0257_2 SOLUTION_2 = new LeetCode0257_2();
    private static final LeetCode0257_3 SOLUTION_3 = new LeetCode0257_3();

    @FunctionalInterface
    interface PathsFunction {
        List<String> apply(TreeNode root);
    }

    private static final Map<String, PathsFunction> ALGO_VARIANTS = Map.of(
            "bfs_iterative_traverse_with_queue", SOLUTION_1::binaryTreePaths,
            "dfs_recursive_traverse", SOLUTION_2::binaryTreePaths,
            "dfs_recursive_traverse_with_string_builder", SOLUTION_3::binaryTreePaths
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testBinaryTreePaths(String caseName, String algoName, Integer[] treeArray, List<String> expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        List<String> actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(sorted(expected), sorted(actual),
                () -> String.format("Case '%s' failed for algo='%s'.", caseName, algoName));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1",
                        new Integer[]{1, 2, 3, null, 5},
                        List.of("1->2->5", "1->3")),

                new TestCase("example_2",
                        new Integer[]{1},
                        List.of("1")),

                new TestCase("empty",
                        null,
                        List.of()),

                // === Additional Coverage ===
                new TestCase("left_skewed",
                        new Integer[]{1, 2, null, 3},
                        List.of("1->2->3")),

                new TestCase("right_skewed",
                        new Integer[]{1, null, 2, null, null, null, 3},
                        List.of("1->2->3"))
        );
    }

    private static List<String> sorted(List<String> values) {
        var copy = new ArrayList<>(values);
        copy.sort(String::compareTo);
        return copy;
    }

    private record TestCase(String name, Integer[] treeArray, List<String> expected) {
    }
}
