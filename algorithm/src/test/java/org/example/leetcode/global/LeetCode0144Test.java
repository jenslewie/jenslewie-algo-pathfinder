package org.example.leetcode.global;

import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.example.builder.BinaryTreeBuilder.build;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 144: Binary Tree Preorder Traversal")
class LeetCode0144Test {

    @FunctionalInterface
    interface PreorderTraversalFunction {
        List<Integer> apply(TreeNode root);
    }

    private static final Map<String, PreorderTraversalFunction> ALGO_VARIANTS = Map.of(
            "recursive_with_instance_list", root -> new LeetCode0144_1().preorderTraversal(root),
            "recursive_with_list_concat", root -> new LeetCode0144_2().preorderTraversal(root),
            "iterative_with_stack", root -> new LeetCode0144_3().preorderTraversal(root)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, root={2}")
    @MethodSource("allCombinations")
    void testPreorderTraversal(String caseName, String algoName, Integer[] treeArray, List<Integer> expected) {
        TreeNode root = build(treeArray);
        List<Integer> actual = ALGO_VARIANTS.get(algoName).apply(root);
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
                // Example 1 from LeetCode: [1,null,2,3] -> [1,2,3]
                new TestCase("example_1", new Integer[]{1, null, 2, null, null, 3}, List.of(1, 2, 3)),

                // Example 2 from LeetCode: [] -> []
                new TestCase("example_2", new Integer[]{}, List.of()),

                // Example 3 from LeetCode: [1] -> [1]
                new TestCase("example_3", new Integer[]{1}, List.of(1)),

                // Full binary tree: [1,2,3,4,5,6,7] -> [1,2,4,5,3,6,7]
                new TestCase("full_tree", new Integer[]{1, 2, 3, 4, 5, 6, 7}, List.of(1, 2, 4, 5, 3, 6, 7)),

                // Left-skewed tree: [1,2,null,3,null,null,null,4] -> [1,2,3,4]
                new TestCase("left_skewed", new Integer[]{1, 2, null, 3, null, null, null, 4}, List.of(1, 2, 3, 4)),

                // Right-skewed tree: [1,null,2,null,null,null,3] -> [1,2,3]
                new TestCase("right_skewed", new Integer[]{1, null, 2, null, null, null, 3}, List.of(1, 2, 3)),

                // Root with only left child
                new TestCase("root_left_only", new Integer[]{1, 2}, List.of(1, 2)),

                // Root with only right child
                new TestCase("root_right_only", new Integer[]{1, null, 2}, List.of(1, 2))
        );
    }

    private record TestCase(String name, Integer[] treeArray, List<Integer> expected) {
    }

}
