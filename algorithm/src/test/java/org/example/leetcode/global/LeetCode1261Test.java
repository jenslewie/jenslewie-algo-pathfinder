package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1261: Find Elements in a Contaminated Binary Tree")
class LeetCode1261Test {

    private static final Map<String, FindElementsFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_traverse_with_fixed_array_membership", LeetCode1261Test::executeV1,
            "dfs_recursive_traverse_with_hashset_membership", LeetCode1261Test::executeV2
    );

    private static List<Boolean> executeV1(TreeNode root, int[] queries) {
        LeetCode1261_1 solution = new LeetCode1261_1(root);
        List<Boolean> ans = new ArrayList<>();
        for (int query : queries) {
            ans.add(solution.find(query));
        }
        return ans;
    }

    private static List<Boolean> executeV2(TreeNode root, int[] queries) {
        LeetCode1261_2 solution = new LeetCode1261_2(root);
        List<Boolean> ans = new ArrayList<>();
        for (int query : queries) {
            ans.add(solution.find(query));
        }
        return ans;
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.queries, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{-1, null, -1}, new int[]{1, 2}, List.of(false, true)),
                new TestCase("example_2", new Integer[]{-1, -1, -1, -1, -1}, new int[]{1, 3, 5}, List.of(true, true, false)),

                // === Additional Coverage ===
                new TestCase("single_root", new Integer[]{-1}, new int[]{0, 1}, List.of(true, false)),
                new TestCase("full_depth_three", new Integer[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{4, 6, 7}, List.of(true, true, false)),
                new TestCase("null_root", new Integer[]{}, new int[]{0, 1000000}, List.of(false, false))
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tree={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int[] queries, List<Boolean> expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        List<Boolean> actual = ALGO_VARIANTS.get(algoName).apply(root, queries);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s, queries=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray), Arrays.toString(queries)));
    }

    @FunctionalInterface
    interface FindElementsFunction {
        List<Boolean> apply(TreeNode root, int[] queries);
    }

    private record TestCase(String name, Integer[] treeArray, int[] queries, List<Boolean> expected) {
    }
}
