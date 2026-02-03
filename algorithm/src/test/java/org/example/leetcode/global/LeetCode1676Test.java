package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.leetcode.utility.BinaryTreeUtility;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 1676: Lowest Common Ancestor of a Binary Tree IV")
class LeetCode1676Test {

    private static final LeetCode1676 SOLUTION = new LeetCode1676();

    @ParameterizedTest(name = "[{index}] case={0}, tree={1}, nodes={2}")
    @MethodSource("testCases")
    void testLowestCommonAncestor(String caseName, Integer[] treeArray, int[] targetVals, int expectedLcaVal) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        TreeNode[] targets = Arrays.stream(targetVals)
                .mapToObj(val -> BinaryTreeUtility.findNodeByValue(root, val))
                .toArray(TreeNode[]::new);

        TreeNode actual = SOLUTION.lowestCommonAncestor(root, targets);
        assertEquals(expectedLcaVal, actual.val,
                () -> String.format("Case '%s' failed. Expected LCA value: %d", caseName, expectedLcaVal));
    }

    @org.junit.jupiter.api.Test
    void testNullRoot() {
        TreeNode actual = SOLUTION.lowestCommonAncestor(null, new TreeNode[0]);
        assertNull(actual, "Expected null LCA for an empty tree");
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example: [3,5,1,6,2,0,8,null,null,7,4], targets=[5,1] → LCA=3
                Arguments.of("example_1",
                        new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                        new int[]{5, 1},
                        3),

                // Same as above, targets=[5,4,7] → LCA=5
                Arguments.of("example_2",
                        new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                        new int[]{5, 4, 7},
                        5),

                // All targets in left subtree
                Arguments.of("all_in_left",
                        new Integer[]{10, 5, 15, 3, 7, null, null, 2, 4, 6, 8},
                        new int[]{2, 4, 6},
                        5),

                // Single target
                Arguments.of("single_target",
                        new Integer[]{1, 2, 3},
                        new int[]{2},
                        2),

                // Root is one of the targets
                Arguments.of("root_in_targets",
                        new Integer[]{10, 5, 15, 3, 7, 12, 20},
                        new int[]{10, 3, 20},
                        10),

                // Two targets, parent-child
                Arguments.of("parent_child_targets",
                        new Integer[]{1, 2, 3, 4, 5},
                        new int[]{2, 4},
                        2),

                // Deep asymmetric tree
                Arguments.of("deep_asymmetric",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5},
                        new int[]{3, 5, 0},
                        2),

                // Targets only in left subtree
                Arguments.of("left_only",
                        new Integer[]{1, 2, 3, 4, null, null, null},
                        new int[]{4},
                        4),

                // Targets only in right subtree
                Arguments.of("right_only",
                        new Integer[]{1, 2, 3, null, null, 4},
                        new int[]{4},
                        4)
        );
    }
}
