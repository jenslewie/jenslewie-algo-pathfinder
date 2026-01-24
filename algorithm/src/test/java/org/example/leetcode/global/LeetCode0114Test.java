package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 114: Flatten Binary Tree to Linked List")
class LeetCode0114Test {

    @FunctionalInterface
    interface FlattenFunction {
        void apply(TreeNode root);
    }

    // Naming convention: [dfs/bfs]_[recursive/iterative]_[traverse/divide_conquer]_with_[metadata]
    private static final Map<String, FlattenFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_queue",
            root -> new LeetCode0114_1().flatten(root),

            "dfs_recursive_divide_conquer_with_tail_traversal",
            root -> new LeetCode0114_2().flatten(root),

            "dfs_recursive_traverse_with_global_head",
            root -> new LeetCode0114_3().flatten(root),

            "dfs_recursive_divide_conquer_with_tail_return",
            root -> new LeetCode0114_4().flatten(root)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testFlatten(String caseName, String algoName, Integer[] input, Integer[] expectedPreorder) {
        TreeNode root = BinaryTreeBuilder.build(input);
        ALGO_VARIANTS.get(algoName).apply(root);
        assertTrue(isFlattenedCorrectly(root, expectedPreorder),
                () -> String.format("Case '%s' with algo='%s' failed.", caseName, algoName));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expectedPreorder))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1: [1,2,5,3,4,null,6] -> [1,2,3,4,5,6]
                new TestCase("example_1",
                        new Integer[]{1, 2, 5, 3, 4, null, 6},
                        new Integer[]{1, 2, 3, 4, 5, 6}),

                // Empty tree
                new TestCase("empty_tree",
                        new Integer[]{},
                        new Integer[]{}),

                // Single node
                new TestCase("single_node",
                        new Integer[]{0},
                        new Integer[]{0}),

                // Left-skewed tree: [1,2,null,3,null,null,null,4] -> [1,2,3,4]
                new TestCase("left_skewed",
                        new Integer[]{1, 2, null, 3, null, null, null, 4},
                        new Integer[]{1, 2, 3, 4}),

                // Right-skewed tree: [1,null,2,null,null,null,3] -> [1,2,3]
                new TestCase("right_skewed",
                        new Integer[]{1, null, 2, null, null, null, 3},
                        new Integer[]{1, 2, 3}),

                // Full binary tree depth 2: [1,2,3] -> [1,2,3]
                new TestCase("full_tree_depth_2",
                        new Integer[]{1, 2, 3},
                        new Integer[]{1, 2, 3})
        );
    }

    // Verify: all left = null, right forms a list, and values match preorder
    private static boolean isFlattenedCorrectly(TreeNode root, Integer[] expectedPreorder) {
        if (expectedPreorder.length == 0) {
            return root == null;
        }

        List<Integer> actual = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                return false; // left must be null
            }
            actual.add(curr.val);
            curr = curr.right;
        }

        List<Integer> expectedList = Arrays.asList(expectedPreorder);
        return actual.equals(expectedList);
    }

    private record TestCase(String name, Integer[] input, Integer[] expectedPreorder) {
    }

}
