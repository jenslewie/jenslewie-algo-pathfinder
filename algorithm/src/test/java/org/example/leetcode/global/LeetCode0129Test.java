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

@DisplayName("LeetCode 129: Sum Root to Leaf Numbers")
class LeetCode0129Test {

    private static final LeetCode0129_1 SOLUTION_1 = new LeetCode0129_1();
    private static final LeetCode0129_2 SOLUTION_2 = new LeetCode0129_2();
    private static final LeetCode0129_3 SOLUTION_3 = new LeetCode0129_3();

    @FunctionalInterface
    interface SumNumbersFunction {
        int apply(TreeNode root);
    }

    private static final Map<String, SumNumbersFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_stringbuilder", SOLUTION_1::sumNumbers,
            "dfs_recursive_traverse_with_integer", SOLUTION_2::sumNumbers,
            "dfs_recursive_divide_conquer_pure", SOLUTION_3::sumNumbers
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testVariantDispatch(String caseName, String algoName, Integer[] treeArray, int expected) {
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
                new TestCase("example_1", new Integer[]{1, 2, 3}, 25),
                new TestCase("example_2", new Integer[]{4, 9, 0, 5, 1}, 1026),
                // Additional Coverage
                new TestCase("single_zero", new Integer[]{0}, 0),
                new TestCase("right_child_only", new Integer[]{1, null, 2}, 12),
                new TestCase("left_chain", new Integer[]{1, 2, null, 3, null}, 123),
                new TestCase("mixed_tree", new Integer[]{9, 9, 9, 9, null, 9, 9}, 2997),
                new TestCase("empty", null, 0)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}