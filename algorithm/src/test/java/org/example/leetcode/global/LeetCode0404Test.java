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

@DisplayName("LeetCode 0404: Sum of Left Leaves")
class LeetCode0404Test {

    private static final LeetCode0404_1 SOLUTION_1 = new LeetCode0404_1();
    private static final LeetCode0404_2 SOLUTION_2 = new LeetCode0404_2();

    @FunctionalInterface
    interface SumOfLeftLeavesFunction {
        int apply(TreeNode root);
    }

    private static final Map<String, SumOfLeftLeavesFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_left_leaf_check", SOLUTION_1::sumOfLeftLeaves,
            "dfs_recursive_divide_conquer_with_left_leaf_check", SOLUTION_2::sumOfLeftLeaves
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{3, 9, 20, null, null, 15, 7}, 24),
                new TestCase("example_2", new Integer[]{1}, 0),

                // === Additional Coverage ===
                new TestCase("empty_tree", new Integer[]{}, 0),
                new TestCase("single_left_leaf", new Integer[]{1, 2}, 2),
                new TestCase("single_right_leaf", new Integer[]{1, null, 2}, 0),
                new TestCase("left_internal_not_leaf", new Integer[]{1, 2, 3, 4, 5}, 4),
                new TestCase("left_has_only_right_child", new Integer[]{1, 2, null, null, 3}, 0),
                new TestCase("deep_right_subtree_left_leaf", new Integer[]{1, null, 2, null, null, 3}, 3),
                new TestCase("multiple_left_leaves", new Integer[]{7, 4, 9, 1, null, 8, 10}, 9)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
