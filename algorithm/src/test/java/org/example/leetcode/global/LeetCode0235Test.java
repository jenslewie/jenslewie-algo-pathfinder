package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.leetcode.utility.BinaryTreeUtility;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 235: Lowest Common Ancestor of a Binary Search Tree")
class LeetCode0235Test {

    private static final LeetCode0235_1 SOLUTION_1 = new LeetCode0235_1();
    private static final LeetCode0235_2 SOLUTION_2 = new LeetCode0235_2();

    @ParameterizedTest(name = "[{index}] case={0}, tree={1}, p={2}, q={3}")
    @MethodSource("testCases")
    void testLowestCommonAncestor(String caseName, Integer[] treeArray, int pVal, int qVal, int expectedLcaVal) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        TreeNode p = BinaryTreeUtility.findNodeByValue(root, pVal);
        TreeNode q = BinaryTreeUtility.findNodeByValue(root, qVal);

        TreeNode actual1 = SOLUTION_1.lowestCommonAncestor(root, p, q);
        TreeNode actual2 = SOLUTION_2.lowestCommonAncestor(root, p, q);

        assertEquals(expectedLcaVal, actual1.val,
                () -> String.format("Case '%s' failed for solution 1. Expected LCA value: %d", caseName, expectedLcaVal));
        assertEquals(expectedLcaVal, actual2.val,
                () -> String.format("Case '%s' failed for solution 2. Expected LCA value: %d", caseName, expectedLcaVal));
    }

    @Test
    void testNullRoot() {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        assertNull(SOLUTION_1.lowestCommonAncestor(null, p, q));
        assertNull(SOLUTION_2.lowestCommonAncestor(null, p, q));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        2, 8, 6),

                Arguments.of("example_2",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        2, 4, 2),

                Arguments.of("left_subtree",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        0, 4, 2),

                Arguments.of("right_subtree",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        7, 9, 8),

                Arguments.of("split_sides_short_circuit",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        8, 4, 6),

                Arguments.of("ancestor_is_root",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9},
                        6, 9, 6)
        );
    }
}
