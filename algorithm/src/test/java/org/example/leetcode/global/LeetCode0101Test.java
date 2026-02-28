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

@DisplayName("LeetCode 0101: Symmetric Tree")
class LeetCode0101Test {

    private static final LeetCode0101 SOLUTION_1 = new LeetCode0101();
    private static final Map<String, IsSymmetricFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_divide_conquer_with_mirror_pair_match", SOLUTION_1::isSymmetric
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.rootArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2, 2, 3, 4, 4, 3}, true),
                new TestCase("example_2", new Integer[]{1, 2, 2, null, 3, null, 3}, false),

                // === Additional Coverage ===
                new TestCase("empty_tree", new Integer[]{}, true),
                new TestCase("single_node", new Integer[]{1}, true),
                new TestCase("child_value_mismatch", new Integer[]{1, 2, 3}, false),
                new TestCase("mirror_value_mismatch_deeper", new Integer[]{1, 2, 2, 3, 4, 4, 5}, false),
                new TestCase("left_present_right_missing_in_mirror_slot", new Integer[]{1, 2, 2, 3, null, 3, null}, false),
                new TestCase("right_mirror_value_mismatch_after_left_match", new Integer[]{1, 2, 2, null, 3, 4, null}, false)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, root={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] rootArray, boolean expected) {
        TreeNode root = BinaryTreeBuilder.build(rootArray);
        boolean actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. root=%s"
                .formatted(caseName, algoName, Arrays.toString(rootArray)));
    }

    @FunctionalInterface
    interface IsSymmetricFunction {
        boolean apply(TreeNode root);
    }

    private record TestCase(String name, Integer[] rootArray, boolean expected) {
    }
}
