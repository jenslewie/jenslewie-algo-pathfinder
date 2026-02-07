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

@DisplayName("LeetCode 1457: Pseudo-Palindromic Paths in a Binary Tree - Algorithm Variants")
class LeetCode1457Test {

    private static final LeetCode1457_1 SOLUTION_1 = new LeetCode1457_1();
    private static final LeetCode1457_2 SOLUTION_2 = new LeetCode1457_2();

    @FunctionalInterface
    interface PseudoPalindromicPathsFunction {
        int apply(TreeNode root);
    }

    private static final Map<String, PseudoPalindromicPathsFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_hashmap", SOLUTION_1::pseudoPalindromicPaths,
            "dfs_recursive_traverse_with_array", SOLUTION_2::pseudoPalindromicPaths
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
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
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{2, 3, 1, 3, 1, null, 1}, 2),
                new TestCase("example_2", new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1}, 1),
                new TestCase("example_3", new Integer[]{9}, 1),

                // === Additional Coverage ===
                new TestCase("empty_tree", new Integer[]{}, 0),
                new TestCase("no_palindromic", new Integer[]{1, 2, 3}, 0),
                new TestCase("left_skewed", new Integer[]{1, 1, null, 1, null, null, null}, 1),
                new TestCase("mixed_missing", new Integer[]{2, 2, 1, null, 3, null, 3}, 1)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
