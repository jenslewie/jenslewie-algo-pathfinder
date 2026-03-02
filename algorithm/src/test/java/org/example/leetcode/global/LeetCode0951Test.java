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

@DisplayName("LeetCode 0951: Flip Equivalent Binary Trees")
class LeetCode0951Test {

    private static final LeetCode0951 SOLUTION_1 = new LeetCode0951();
    private static final Map<String, FlipEquivFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_divide_conquer_with_flip_branching_match", SOLUTION_1::flipEquiv
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.root1Array, tc.root2Array, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1",
                        new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8},
                        new Integer[]{1, 3, 2, null, 6, 4, 5, null, null, null, null, null, null, 8, 7},
                        true),
                new TestCase("example_2", new Integer[]{}, new Integer[]{}, true),
                new TestCase("example_3", new Integer[]{}, new Integer[]{1}, false),

                // === Additional Coverage ===
                new TestCase("single_node_equal", new Integer[]{1}, new Integer[]{1}, true),
                new TestCase("single_node_not_equal", new Integer[]{1}, new Integer[]{2}, false),
                new TestCase("root_level_flip_needed", new Integer[]{1, 2, 3}, new Integer[]{1, 3, 2}, true),
                new TestCase("same_structure_not_flip_equivalent", new Integer[]{1, 2, 3}, new Integer[]{1, 2, 4}, false),
                new TestCase("flip_left_match_but_flip_right_mismatch", new Integer[]{1, 2, 3}, new Integer[]{1, 4, 2}, false)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, root1={2}, root2={3}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] root1Array, Integer[] root2Array, boolean expected) {
        TreeNode root1 = BinaryTreeBuilder.build(root1Array);
        TreeNode root2 = BinaryTreeBuilder.build(root2Array);
        boolean actual = ALGO_VARIANTS.get(algoName).apply(root1, root2);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. root1=%s, root2=%s"
                .formatted(caseName, algoName, Arrays.toString(root1Array), Arrays.toString(root2Array)));
    }

    @FunctionalInterface
    interface FlipEquivFunction {
        boolean apply(TreeNode root1, TreeNode root2);
    }

    private record TestCase(String name, Integer[] root1Array, Integer[] root2Array, boolean expected) {
    }
}
