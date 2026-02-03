package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 111: Minimum Depth of Binary Tree - Algorithm Variants")
class LeetCode0111Test {

    private static final LeetCode0111_1 SOLUTION_1 = new LeetCode0111_1();
    private static final LeetCode0111_2 SOLUTION_2 = new LeetCode0111_2();

    private static final Map<String, Function<TreeNode, Integer>> ALGO_VARIANTS = Map.of(
            "bfs_approach", SOLUTION_1::minDepth,
            "dfs_traversal_approach", SOLUTION_2::minDepth
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testMinDepth(String caseName, String algoName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.buildTree(treeArray, 0);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("empty_tree", new Integer[]{}, 0),
                new TestCase("single_node", new Integer[]{1}, 1),
                new TestCase("right_skewed", new Integer[]{1, null, 3, null, null, null, 7}, 3),
                new TestCase("left_skewed", new Integer[]{1, 2, null, 3}, 3),
                new TestCase("full_two_levels", new Integer[]{1, 2, 3}, 2),
                new TestCase("left_only_child", new Integer[]{1, 2}, 2),
                new TestCase("right_only_child", new Integer[]{1, null, 2}, 2)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
