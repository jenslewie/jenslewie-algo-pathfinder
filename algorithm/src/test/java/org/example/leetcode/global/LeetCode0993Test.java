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

@DisplayName("LeetCode 0993: Cousins in Binary Tree")
class LeetCode0993Test {

    private static final LeetCode0993_1 SOLUTION_1 = new LeetCode0993_1();
    private static final LeetCode0993_2 SOLUTION_2 = new LeetCode0993_2();
    private static final Map<String, IsCousinsFunction> ALGO_VARIANTS = Map.of(
            "bfs_iterative_traverse_with_level_parent_tracking", SOLUTION_1::isCousins,
            "dfs_recursive_traverse_with_parent_depth_tracking", SOLUTION_2::isCousins
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.x, tc.y, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2, 3, 4}, 4, 3, false),
                new TestCase("example_2", new Integer[]{1, 2, 3, null, 4, null, 5}, 5, 4, true),
                new TestCase("example_3", new Integer[]{1, 2, 3, null, 4}, 2, 3, false),

                // === Additional Coverage ===
                new TestCase("same_parent_not_cousins", new Integer[]{1, 2, 3, 4, 5}, 4, 5, false),
                new TestCase("different_parents_same_depth", new Integer[]{1, 2, 3, 4, null, null, 5}, 4, 5, true),
                new TestCase("both_children_of_root", new Integer[]{1, 2, 3}, 2, 3, false),
                new TestCase("targets_absent_returns_false", new Integer[]{1, 2, 3}, 4, 5, false)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int x, int y, boolean expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        boolean actual = ALGO_VARIANTS.get(algoName).apply(root, x, y);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s, x=%d, y=%d"
                .formatted(caseName, algoName, Arrays.toString(treeArray), x, y));
    }

    @FunctionalInterface
    interface IsCousinsFunction {
        boolean apply(TreeNode root, int x, int y);
    }

    private record TestCase(String name, Integer[] treeArray, int x, int y, boolean expected) {
    }
}
