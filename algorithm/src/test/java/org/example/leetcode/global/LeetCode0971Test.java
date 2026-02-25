package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0971: Flip Binary Tree To Match Preorder Traversal")
class LeetCode0971Test {

    private static final LeetCode0971 SOLUTION_1 = new LeetCode0971();
    private static final Map<String, FlipMatchVoyageFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_preorder_with_conditional_child_flip", SOLUTION_1::flipMatchVoyage
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.voyage, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2}, new int[]{2, 1}, List.of(-1)),
                new TestCase("example_2", new Integer[]{1, 2, 3}, new int[]{1, 3, 2}, List.of(1)),
                new TestCase("example_3", new Integer[]{1, 2, 3}, new int[]{1, 2, 3}, List.of()),

                // === Additional Coverage ===
                new TestCase("empty_tree", new Integer[]{}, new int[]{}, List.of()),
                new TestCase("deeper_single_flip", new Integer[]{1, 2, 3, 4, null, null, 5}, new int[]{1, 3, 5, 2, 4}, List.of(1)),
                new TestCase("impossible_mismatch_after_flip", new Integer[]{1, 2, 3}, new int[]{1, 3, 4}, List.of(-1)),
                new TestCase("mismatch_then_short_circuit_remaining_branch", new Integer[]{1, 2, 3, 4}, new int[]{1, 2, 9, 4, 3}, List.of(-1))
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int[] voyage, List<Integer> expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        List<Integer> actual = ALGO_VARIANTS.get(algoName).apply(root, voyage);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s, voyage=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray), Arrays.toString(voyage)));
    }

    @FunctionalInterface
    interface FlipMatchVoyageFunction {
        List<Integer> apply(TreeNode root, int[] voyage);
    }

    private record TestCase(String name, Integer[] treeArray, int[] voyage, List<Integer> expected) {
    }
}
