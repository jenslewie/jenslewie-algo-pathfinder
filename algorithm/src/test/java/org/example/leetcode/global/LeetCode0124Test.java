package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0124: Binary Tree Maximum Path Sum")
class LeetCode0124Test {

    private static final LeetCode0124 SOLUTION_1 = new LeetCode0124();
    private static final Map<String, MaxPathSumFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_postorder_with_global_best_path_sum", SOLUTION_1::maxPathSum
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.rootArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2, 3}, 6),
                new TestCase("example_2", new Integer[]{-10, 9, 20, null, null, 15, 7}, 42),

                // === Additional Coverage ===
                new TestCase("single_negative_node", new Integer[]{-3}, -3),
                new TestCase("all_negative_nodes", new Integer[]{-3, -2, -1}, -1),
                new TestCase("right_skewed_positive_chain", new Integer[]{1, null, 2, null, null, null, 3}, 6),
                new TestCase("drop_negative_subtrees", new Integer[]{2, -1, -2}, 2),
                new TestCase("balanced_mixed_tree", new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}, 49)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, root={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] rootArray, int expected) {
        TreeNode root = BinaryTreeBuilder.build(rootArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. root=%s"
                .formatted(caseName, algoName, Arrays.toString(rootArray)));
    }

    @FunctionalInterface
    interface MaxPathSumFunction {
        int apply(TreeNode root);
    }

    private record TestCase(String name, Integer[] rootArray, int expected) {
    }
}
