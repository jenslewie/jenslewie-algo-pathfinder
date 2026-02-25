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

@DisplayName("LeetCode 0437: Path Sum III")
class LeetCode0437Test {

    private static final LeetCode0437_1 SOLUTION_1 = new LeetCode0437_1();
    private static final LeetCode0437_2 SOLUTION_2 = new LeetCode0437_2();
    private static final Map<String, PathSumFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_running_path_sums", SOLUTION_1::pathSum,
            "dfs_recursive_traverse_with_prefix_sum_hashmap", SOLUTION_2::pathSum
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.targetSum, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1",
                        new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1},
                        8,
                        3),
                new TestCase("example_2",
                        new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1},
                        22,
                        3),

                // === Additional Coverage ===
                new TestCase("empty_tree", new Integer[]{}, 0, 0),
                new TestCase("single_node_equal_target", new Integer[]{1}, 1, 1),
                new TestCase("negative_and_zero_target", new Integer[]{1, -1, -1}, 0, 2),
                new TestCase("target_not_found", new Integer[]{1, 2, 3}, 99, 0)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int targetSum, int expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root, targetSum);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s, target=%d"
                .formatted(caseName, algoName, Arrays.toString(treeArray), targetSum));
    }

    @FunctionalInterface
    interface PathSumFunction {
        int apply(TreeNode root, int targetSum);
    }

    private record TestCase(String name, Integer[] treeArray, int targetSum, int expected) {
    }
}
