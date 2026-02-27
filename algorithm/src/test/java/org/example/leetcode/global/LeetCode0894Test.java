package org.example.leetcode.global;

import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 0894: All Possible Full Binary Trees")
class LeetCode0894Test {

    private static final LeetCode0894 SOLUTION_1 = new LeetCode0894();
    private static final Map<String, AllPossibleFBTFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_divide_conquer_with_odd_size_partition", SOLUTION_1::allPossibleFBT
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.n, tc.expectedCount, tc.expectedSerializedTrees))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", 7, 5, null),
                new TestCase("example_2", 3, 1, List.of("0,0,#,#,0,#,#")),

                // === Additional Coverage ===
                new TestCase("single_node", 1, 1, List.of("0,#,#")),
                new TestCase("even_nodes_return_empty", 2, 0, List.of()),
                new TestCase("nine_nodes_count", 9, 14, null)
        );
    }

    private static boolean isFullTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        if ((node.left == null) != (node.right == null)) {
            return false;
        }
        return isFullTree(node.left) && isFullTree(node.right);
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private static String serializePreorder(TreeNode node) {
        if (node == null) {
            return "#";
        }
        return node.val + "," + serializePreorder(node.left) + "," + serializePreorder(node.right);
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, n={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int n, int expectedCount, List<String> expectedSerializedTrees) {
        List<TreeNode> actualTrees = ALGO_VARIANTS.get(algoName).apply(n);
        assertEquals(expectedCount, actualTrees.size(),
                () -> "Case '%s' with algo='%s' failed on count for n=%d".formatted(caseName, algoName, n));

        List<String> serialized = new ArrayList<>();
        for (TreeNode root : actualTrees) {
            assertTrue(isFullTree(root), () -> "Case '%s' produced non-full tree for n=%d".formatted(caseName, n));
            assertEquals(n, countNodes(root), () -> "Case '%s' produced tree with wrong node count for n=%d".formatted(caseName, n));
            serialized.add(serializePreorder(root));
        }

        Set<String> unique = new HashSet<>(serialized);
        assertEquals(serialized.size(), unique.size(),
                () -> "Case '%s' produced duplicate tree structures for n=%d".formatted(caseName, n));

        if (expectedSerializedTrees != null) {
            assertEquals(new HashSet<>(expectedSerializedTrees), unique,
                    () -> "Case '%s' produced unexpected tree structures for n=%d".formatted(caseName, n));
        }
    }

    @FunctionalInterface
    interface AllPossibleFBTFunction {
        List<TreeNode> apply(int n);
    }

    private record TestCase(String name, int n, int expectedCount, List<String> expectedSerializedTrees) {
    }
}
