package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 199: Binary Tree Right Side View")
class LeetCode0199Test {

    private static final LeetCode0199_1 SOLUTION_1 = new LeetCode0199_1();
    private static final LeetCode0199_2 SOLUTION_2 = new LeetCode0199_2();

    @FunctionalInterface
    interface RightSideViewFunction {
        List<Integer> apply(TreeNode root);
    }

    private static final Map<String, RightSideViewFunction> ALGO_VARIANTS = Map.of(
            "bfs_level_order_traversal", SOLUTION_1::rightSideView,
            "dfs_right_first_traversal", SOLUTION_2::rightSideView
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    @DisplayName("Variant Dispatch Test")
    void testVariantDispatch(String caseName, String algoName, Integer[] treeArray, List<Integer> expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        var actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '" + caseName + "' failed.");
    }

    static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected)));
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // LeetCode Official Examples
                new TestCase("example_1", new Integer[]{1, 2, 3, null, 5, null, 4}, List.of(1, 3, 4)),
                new TestCase("example_2", new Integer[]{1, 2, 3, 4, null, null, null, 5}, List.of(1, 3, 4, 5)),
                new TestCase("example_3", new Integer[]{1, null, 3}, List.of(1, 3)),
                // Additional Coverage
                new TestCase("empty_tree", null, List.of()),
                new TestCase("single_node", new Integer[]{1}, List.of(1)),
                new TestCase("left_skewed", new Integer[]{1, 2, null, 3, null, 4}, List.of(1, 2, 3)),
                new TestCase("right_skewed", new Integer[]{1, null, 2, null, 3, null, 4}, List.of(1, 2, 4)),
                new TestCase("complete_binary_tree", new Integer[]{1, 2, 3, 4, 5, 6, 7}, List.of(1, 3, 7))
        );
    }

    private record TestCase(String name, Integer[] treeArray, List<Integer> expected) {
    }
}
