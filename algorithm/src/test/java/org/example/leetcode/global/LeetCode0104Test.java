package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 104: Maximum Depth of Binary Tree")
class LeetCode0104Test {

    private final LeetCode0104 solution = new LeetCode0104();

    @ParameterizedTest(name = "[{index}] case={0}")
    @MethodSource("testCases")
    void testMaxDepth(String caseName, Integer[] treeArray, int expected) {
        var root = BinaryTreeBuilder.build(treeArray);
        int actual = solution.maxDepth(root);
        assertEquals(expected, actual, () -> "Case '" + caseName + "' failed.");
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1: [3,9,20,null,null,15,7]
                Arguments.of("example_1", new Integer[]{3, 9, 20, null, null, 15, 7}, 3),

                // Example 2: [1,null,2]
                Arguments.of("example_2", new Integer[]{1, null, 2}, 2),

                // Single node
                Arguments.of("single_node", new Integer[]{1}, 1),

                // Empty tree
                Arguments.of("empty_tree", new Integer[]{}, 0),

                // All null (treated as empty)
                Arguments.of("all_null", new Integer[]{null}, 0),

                // Left-skewed tree: [1,2,null,3,null,null,null,4]
                Arguments.of("left_skewed", new Integer[]{1, 2, null, 3, null, null, null, 4}, 4),

                // Right-skewed tree: [1,null,2,null,null,null,3]
                Arguments.of("right_skewed", new Integer[]{1, null, 2, null, null, null, 3}, 3),

                // Full binary tree of depth 3: [1,2,3,4,5,6,7]
                Arguments.of("full_tree_depth_3", new Integer[]{1, 2, 3, 4, 5, 6, 7}, 3)
        );
    }

}
