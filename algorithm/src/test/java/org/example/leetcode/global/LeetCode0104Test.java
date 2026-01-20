package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.example.builder.BinaryTreeBuilder.build;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 104: Maximum Depth of Binary Tree")
class LeetCode0104Test {

    @FunctionalInterface
    interface MaxDepthFunction {
        int apply(org.example.model.tree.TreeNode root);
    }

    private static final Map<String, MaxDepthFunction> ALGO_VARIANTS = Map.of(
            "recursive_post_order", root -> new LeetCode0104_1().maxDepth(root),
            "dfs_with_global_state", root -> new LeetCode0104_2().maxDepth(root)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testMaxDepth(String caseName, String algoName, Integer[] treeArray, int expected) {
        var root = build(treeArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> String.format(
                "Case '%s' with algo='%s' failed.", caseName, algoName));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode: [3,9,20,null,null,15,7] -> 3
                new TestCase("example_1", new Integer[]{3, 9, 20, null, null, 15, 7}, 3),

                // Example 2 from LeetCode: [1,null,2] -> 2
                new TestCase("example_2", new Integer[]{1, null, 2}, 2),

                // Empty tree
                new TestCase("empty_tree", new Integer[]{}, 0),

                // Single node
                new TestCase("single_node", new Integer[]{1}, 1),

                // Root with two null children
                new TestCase("root_with_null_children", new Integer[]{1, null, null}, 1),

                // Left-skewed tree
                new TestCase("left_skewed", new Integer[]{1, 2, null, 3, null, null, null, 4}, 4),

                // Right-skewed tree
                new TestCase("right_skewed", new Integer[]{1, null, 2, null, null, null, 3}, 3),

                // Full binary tree of depth 3
                new TestCase("full_tree_depth_3", new Integer[]{1, 2, 3, 4, 5, 6, 7}, 3)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }

}
