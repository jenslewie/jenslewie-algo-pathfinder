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

@DisplayName("LeetCode 0513: Find Bottom Left Tree Value")
class LeetCode0513Test {

    private static final LeetCode0513_1 SOLUTION_1 = new LeetCode0513_1();
    private static final LeetCode0513_2 SOLUTION_2 = new LeetCode0513_2();
    private static final LeetCode0513_3 SOLUTION_3 = new LeetCode0513_3();
    private static final Map<String, FindBottomLeftValueFunction> ALGO_VARIANTS = Map.of(
            "bfs_iterative_traverse_with_level_order_queue", SOLUTION_1::findBottomLeftValue,
            "dfs_recursive_traverse_with_depth_first_value_map", SOLUTION_2::findBottomLeftValue,
            "dfs_recursive_traverse_with_first_hit_per_depth", SOLUTION_3::findBottomLeftValue
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{2, 1, 3}, 1),
                new TestCase("example_2", new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, null, null, 7}, 7),

                // === Additional Coverage ===
                new TestCase("single_node", new Integer[]{1}, 1),
                new TestCase("left_skewed", new Integer[]{1, 2, null, 3, null, null, null, 4}, 4),
                new TestCase("right_skewed", new Integer[]{1, null, 2, null, null, null, 3}, 3),
                new TestCase("deepest_level_multiple_nodes", new Integer[]{1, 2, 3, null, 4, 5, null}, 4)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray)));
    }

    @FunctionalInterface
    interface FindBottomLeftValueFunction {
        int apply(TreeNode root);
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
