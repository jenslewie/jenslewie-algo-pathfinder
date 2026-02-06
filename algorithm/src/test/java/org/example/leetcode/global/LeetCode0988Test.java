package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 988: Smallest String Starting From Leaf")
class LeetCode0988Test {

    private static final LeetCode0988 SOLUTION_1 = new LeetCode0988();

    @FunctionalInterface
    interface SmallestStringFunction {
        String apply(TreeNode root);
    }

    private static final Map<String, SmallestStringFunction> ALGO_VARIANTS = Map.of(
            "dfs_backtracking_approach", SOLUTION_1::smallestFromLeaf
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testVariantDispatch(String caseName, String algoName, Integer[] treeArray, String expected) {
        TreeNode root = BinaryTreeBuilder.buildTree(treeArray, 0);
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
                new TestCase("example_1", new Integer[]{0, 1, 2, 3, 4, 3, 4}, "dba"),
                new TestCase("example_2", new Integer[]{25, 1, 3, 1, 3, 0, 2}, "adz"),
                new TestCase("example_3", new Integer[]{2, 2, 1, null, 1, 0, null, 0}, "abc"),
                // Additional Coverage
                new TestCase("single_node", new Integer[]{0}, "a"),
                new TestCase("simple_tree", new Integer[]{1, 0, 2}, "ab"),
                new TestCase("zigzag_tree", new Integer[]{3, 1, 4, 0, 2}, "abd"),
                new TestCase("equal_paths", new Integer[]{0, 1, 1, 2, 2}, "ba")
        );
    }

    private record TestCase(String name, Integer[] treeArray, String expected) {
    }
}