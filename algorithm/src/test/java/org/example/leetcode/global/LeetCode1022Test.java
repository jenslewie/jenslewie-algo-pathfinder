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

@DisplayName("LeetCode 1022: Sum of Root To Leaf Binary Numbers - Algorithm Variants")
class LeetCode1022Test {

    private static final LeetCode1022 SOLUTION_1 = new LeetCode1022();

    @FunctionalInterface
    interface SolutionFunction {
        Integer apply(TreeNode root);
    }

    private static final Map<String, SolutionFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_path", SOLUTION_1::sumRootToLeaf
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
                new TestCase("example_1", new Integer[]{1, 0, 1, 0, 1, 0, 1}, 22),
                new TestCase("example_2", new Integer[]{0}, 0),

                // === Additional Coverage ===
                new TestCase("single_one", new Integer[]{1}, 1),
                new TestCase("left_skewed", new Integer[]{1, 0, null, 1, null, null, null}, 5),
                new TestCase("right_skewed", new Integer[]{1, null, 1, null, null, null, 0}, 6),
                new TestCase("mixed_missing", new Integer[]{1, 0, 1, null, 1, null, 0}, 11),
                new TestCase("empty_tree", new Integer[]{}, 0)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
