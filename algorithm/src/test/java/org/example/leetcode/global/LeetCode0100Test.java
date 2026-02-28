package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0100: Same Tree")
class LeetCode0100Test {

    private static final LeetCode0100 SOLUTION_1 = new LeetCode0100();
    private static final Map<String, IsSameTreeFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_divide_conquer_with_pairwise_node_match", SOLUTION_1::isSameTree
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.pArray, tc.qArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}, true),
                new TestCase("example_2", new Integer[]{1, 2}, new Integer[]{1, null, 2}, false),
                new TestCase("example_3", new Integer[]{1, 2, 1}, new Integer[]{1, 1, 2}, false),

                // === Additional Coverage ===
                new TestCase("both_empty", new Integer[]{}, new Integer[]{}, true),
                new TestCase("one_empty", new Integer[]{1}, new Integer[]{}, false),
                new TestCase("one_empty_reversed", new Integer[]{}, new Integer[]{1}, false),
                new TestCase("single_node_equal", new Integer[]{7}, new Integer[]{7}, true),
                new TestCase("single_node_not_equal", new Integer[]{7}, new Integer[]{8}, false),
                new TestCase("right_subtree_not_equal", new Integer[]{1, 2, 3}, new Integer[]{1, 2, 4}, false)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, p={2}, q={3}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] pArray, Integer[] qArray, boolean expected) {
        TreeNode p = BinaryTreeBuilder.build(pArray);
        TreeNode q = BinaryTreeBuilder.build(qArray);
        boolean actual = ALGO_VARIANTS.get(algoName).apply(p, q);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. p=%s, q=%s"
                .formatted(caseName, algoName, Arrays.toString(pArray), Arrays.toString(qArray)));
    }

    @FunctionalInterface
    interface IsSameTreeFunction {
        boolean apply(TreeNode p, TreeNode q);
    }

    private record TestCase(String name, Integer[] pArray, Integer[] qArray, boolean expected) {
    }
}
