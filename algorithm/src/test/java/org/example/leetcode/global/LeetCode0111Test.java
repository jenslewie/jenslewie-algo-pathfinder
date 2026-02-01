package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 111: Minimum Depth of Binary Tree")
class LeetCode0111Test {

    private static final LeetCode0111 LEET_CODE = new LeetCode0111();

    @ParameterizedTest(name = "[{index}] case={0}, tree={1}")
    @MethodSource("testCases")
    void testMinDepth(String caseName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.buildTree(treeArray, 0);
        int actual = LEET_CODE.minDepth(root);
        assertEquals(expected, actual, () -> "Case '%s' failed. tree=%s"
                .formatted(caseName, Arrays.toString(treeArray)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("empty_tree", new Integer[]{}, 0),
                Arguments.of("single_node", new Integer[]{1}, 1),
                Arguments.of("right_skewed", new Integer[]{1, null, 3, null, null, null, 7}, 3)
        );
    }
}
