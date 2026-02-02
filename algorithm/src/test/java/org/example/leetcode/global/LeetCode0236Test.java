package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.leetcode.utility.BinaryTreeUtility;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 236: Lowest Common Ancestor of a Binary Tree")
class LeetCode0236Test {

    private static final LeetCode0236 SOLUTION = new LeetCode0236();

    @ParameterizedTest(name = "[{index}] case={0}, tree={1}, p={2}, q={3}")
    @MethodSource("testCases")
    void testLowestCommonAncestor(String caseName, Integer[] treeArray, int pVal, int qVal, int expectedLcaVal) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        TreeNode p = BinaryTreeUtility.findNodeByValue(root, pVal);
        TreeNode q = BinaryTreeUtility.findNodeByValue(root, qVal);

        TreeNode actual = SOLUTION.lowestCommonAncestor(root, p, q);
        assertEquals(expectedLcaVal, actual.val,
                () -> String.format("Case '%s' failed. Expected LCA value: %d", caseName, expectedLcaVal));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                Arguments.of("example_1",
                        new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                        5, 1, 3),

                Arguments.of("example_2",
                        new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                        5, 4, 5),

                Arguments.of("example_3",
                        new Integer[]{1, 2},
                        1, 2, 1),

                // === Edge Cases ===
                Arguments.of("same_node",
                        new Integer[]{1, 2, 3},
                        2, 2, 2),

                Arguments.of("one_is_root",
                        new Integer[]{1, 2, 3, 4, 5},
                        1, 5, 1),

                // === Both in left subtree ===
                Arguments.of("both_in_left",
                        new Integer[]{10, 5, 15, 3, 7, null, null, 2, 4, 6, 8},
                        2, 4, 3),

                // === Both in right subtree ===
                Arguments.of("both_in_right",
                        new Integer[]{10, 5, 15, null, null, 12, 20, null, null, null, null, 11, 13},
                        11, 20, 15),

                // === Single node ===
                Arguments.of("single_node",
                        new Integer[]{42},
                        42, 42, 42),

                // === Deep asymmetric tree ===
                Arguments.of("deep_asymmetric",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        3, 9, 6)
        );
    }
}
