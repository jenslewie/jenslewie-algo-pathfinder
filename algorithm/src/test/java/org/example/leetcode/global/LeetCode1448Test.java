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

@DisplayName("LeetCode 1448: Count Good Nodes in Binary Tree")
class LeetCode1448Test {

    private static final LeetCode1448 SOLUTION_1 = new LeetCode1448();
    private static final Map<String, GoodNodesFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_path_max_tracking", SOLUTION_1::goodNodes
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{3, 1, 4, 3, null, 1, 5}, 4),
                new TestCase("example_2", new Integer[]{3, 3, null, 4, 2}, 3),
                new TestCase("example_3", new Integer[]{1}, 1),

                // === Additional Coverage ===
                new TestCase("all_equal_values", new Integer[]{2, 2, 2}, 3),
                new TestCase("strictly_decreasing_path", new Integer[]{5, 4, null, 3, null, null, null, 2, null, null, null, null, null, null, null, 1}, 1),
                new TestCase("mixed_tree", new Integer[]{5, 4, 6, 3, null, 5, 7}, 3)
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
    interface GoodNodesFunction {
        int apply(TreeNode root);
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
