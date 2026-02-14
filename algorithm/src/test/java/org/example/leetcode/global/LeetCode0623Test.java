package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.leetcode.utility.BinaryTreeUtility;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 0623: Add One Row to Tree")
class LeetCode0623Test {

    private static final LeetCode0623_1 SOLUTION_1 = new LeetCode0623_1();
    private static final LeetCode0623_2 SOLUTION_2 = new LeetCode0623_2();
    private static final LeetCode0623_3 SOLUTION_3 = new LeetCode0623_3();
    private static final Map<String, AddOneRowFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_depth_tracking", SOLUTION_1::addOneRow,
            "dfs_recursive_divide_conquer_with_depth_countdown", SOLUTION_2::addOneRow,
            "bfs_iterative_traverse_with_level_order_queue", SOLUTION_3::addOneRow
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.val, tc.depth, tc.expectedTreeArray))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1",
                        new Integer[]{4, 2, 6, 3, 1, 5},
                        1,
                        2,
                        new Integer[]{4, 1, 1, 2, null, null, 6, 3, 1, null, null, null, null, 5}),
                new TestCase("example_2",
                        new Integer[]{4, 2, null, 3, 1},
                        1,
                        3,
                        new Integer[]{4, 2, null, 1, 1, null, null, 3, null, null, 1}),

                // === Additional Coverage ===
                new TestCase("depth_is_one_new_root",
                        new Integer[]{4, 2, 6, 3, 1, 5},
                        1,
                        1,
                        new Integer[]{1, 4, null, 2, 6, null, null, 3, 1, 5}),
                new TestCase("single_node_insert_both_children",
                        new Integer[]{1},
                        5,
                        2,
                        new Integer[]{1, 5, 5}),
                new TestCase("sparse_tree_depth_four",
                        new Integer[]{1, 2, 3, 4},
                        5,
                        4,
                        new Integer[]{1, 2, 3, 4, null, null, null, 5, 5})
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}, val={3}, depth={4}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int val, int depth, Integer[] expectedTreeArray) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        TreeNode expected = BinaryTreeBuilder.build(expectedTreeArray);
        TreeNode actual = ALGO_VARIANTS.get(algoName).apply(root, val, depth);
        assertTrue(BinaryTreeUtility.isSameTree(expected, actual),
                () -> "Case '%s' with algo='%s' failed. input=%s, val=%d, depth=%d, expected=%s"
                        .formatted(caseName, algoName, Arrays.toString(treeArray), val, depth, Arrays.toString(expectedTreeArray)));
    }

    @FunctionalInterface
    interface AddOneRowFunction {
        TreeNode apply(TreeNode root, int val, int depth);
    }

    private record TestCase(String name, Integer[] treeArray, int val, int depth, Integer[] expectedTreeArray) {
    }
}
