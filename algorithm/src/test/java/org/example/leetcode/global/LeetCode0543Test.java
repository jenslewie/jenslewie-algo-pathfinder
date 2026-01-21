package org.example.leetcode.global;

import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.builder.BinaryTreeBuilder.build;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 543: Diameter of Binary Tree")
class LeetCode0543Test {

    private final LeetCode0543 solution = new LeetCode0543();

    @ParameterizedTest(name = "[{index}] case={0}, root={1}")
    @MethodSource("testCases")
    void testDiameterOfBinaryTree(String caseName, Integer[] treeArray, int expected) {
        TreeNode root = build(treeArray);
        int actual = solution.diameterOfBinaryTree(root);
        assertEquals(expected, actual, () -> "Case '" + caseName + "' failed.");
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode: [1,2,3,4,5] -> diameter = 3 (path [4,2,1,3] or [5,2,1,3])
                Arguments.of("example_1", new Integer[]{1, 2, 3, 4, 5}, 3),

                // Example 2 from LeetCode: [1,2] -> diameter = 1
                Arguments.of("example_2", new Integer[]{1, 2}, 1),

                // Single node
                Arguments.of("single_node", new Integer[]{1}, 0),

                // Empty tree
                Arguments.of("empty_tree", new Integer[]{}, 0),

                // Skewed tree (no branching): path [4,3,2,1]
                Arguments.of("skewed", new Integer[]{1, 2, null, 3, null, null, null, 4}, 3),

                // Full binary tree of depth 3: [1,2,3,4,5,6,7]: path [4,2,1,3,6] or [5,2,1,3,7], and so on
                Arguments.of("full_tree_depth_3", new Integer[]{1, 2, 3, 4, 5, 6, 7}, 4),

                // Root with only right subtree: path [4,3,2,1]
                Arguments.of("right_deep", new Integer[]{1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4}, 3),

                // The longest diameter does not go through root: path [6,4,3,5,7]
                Arguments.of("not_go_through_root", new Integer[]{1, 2, 3, 4, 5, null, null, 6, null, null, 7}, 4)
        );
    }

}
