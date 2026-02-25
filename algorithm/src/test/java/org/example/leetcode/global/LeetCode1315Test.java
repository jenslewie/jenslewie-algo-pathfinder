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

@DisplayName("LeetCode 1315: Sum of Nodes with Even-Valued Grandparent")
class LeetCode1315Test {

    private static final LeetCode1315 SOLUTION_1 = new LeetCode1315();
    private static final Map<String, SumEvenGrandparentFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_parent_grandparent_tracking", SOLUTION_1::sumEvenGrandparent
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5}, 18),
                new TestCase("example_2", new Integer[]{1}, 0),

                // === Additional Coverage ===
                new TestCase("all_grandchildren_counted_from_even_root", new Integer[]{2, 1, 3, 4, 5, 6, 7}, 22),
                new TestCase("odd_grandparent_contributes_nothing", new Integer[]{5, 2, 7, 1, 3, 6, 8}, 0),
                new TestCase("empty_tree", new Integer[]{}, 0)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray)));
    }

    @FunctionalInterface
    interface SumEvenGrandparentFunction {
        int apply(TreeNode root);
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
