package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1110: Delete Nodes And Return Forest")
class LeetCode1110Test {

    private static final LeetCode1110 SOLUTION_1 = new LeetCode1110();
    private static final Map<String, DelNodesFunction> ALGO_VARIANTS = Map.of(
            "dfs_recursive_postorder_with_delete_set_filter", SOLUTION_1::delNodes
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.toDelete, tc.expectedForestArrays))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1",
                        new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        new int[]{3, 5},
                        List.of(
                                new Integer[]{1, 2, null, 4},
                                new Integer[]{6},
                                new Integer[]{7}
                        )),
                new TestCase("example_2",
                        new Integer[]{1, 2, 4, null, 3},
                        new int[]{3},
                        List.<Integer[]>of(
                                new Integer[]{1, 2, 4}
                        )),

                // === Additional Coverage ===
                new TestCase("delete_root_only",
                        new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        new int[]{1},
                        List.of(
                                new Integer[]{2, 4, 5},
                                new Integer[]{3, 6, 7}
                        )),
                new TestCase("delete_none",
                        new Integer[]{1, 2, 3},
                        new int[]{},
                        List.<Integer[]>of(
                                new Integer[]{1, 2, 3}
                        )),
                new TestCase("delete_all",
                        new Integer[]{1},
                        new int[]{1},
                        List.of()),
                new TestCase("delete_non_exist_node",
                        new Integer[]{1, 2, 3, 4, 5},
                        new int[]{7},
                        List.<Integer[]>of(
                                new Integer[]{1, 2, 3, 4, 5}
                        )),
                new TestCase("delete_partial_exist_node",
                        new Integer[]{1, 2, 3, 4, 5},
                        new int[]{2, 7},
                        List.of(
                                new Integer[]{1, null, 3},
                                new Integer[]{4},
                                new Integer[]{5}
                        )),
                new TestCase("empty_tree",
                        new Integer[]{},
                        new int[]{1, 2},
                        List.of())
        );
    }

    private static Set<String> expectedForestAsSet(List<Integer[]> expectedForestArrays) {
        Set<String> expected = new HashSet<>();
        for (Integer[] treeArray : expectedForestArrays) {
            expected.add(serializePreorder(BinaryTreeBuilder.build(treeArray)));
        }
        return expected;
    }

    private static Set<String> actualForestAsSet(List<TreeNode> forest) {
        Set<String> actual = new HashSet<>();
        for (TreeNode root : forest) {
            actual.add(serializePreorder(root));
        }
        return actual;
    }

    private static String serializePreorder(TreeNode node) {
        if (node == null) {
            return "#";
        }
        return node.val + "," + serializePreorder(node.left) + "," + serializePreorder(node.right);
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] treeArray, int[] toDelete, List<Integer[]> expectedForestArrays) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        List<TreeNode> actualForest = ALGO_VARIANTS.get(algoName).apply(root, toDelete);

        Set<String> expected = expectedForestAsSet(expectedForestArrays);
        Set<String> actual = actualForestAsSet(actualForest);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tree=%s, toDelete=%s"
                .formatted(caseName, algoName, Arrays.toString(treeArray), Arrays.toString(toDelete)));
    }

    @FunctionalInterface
    interface DelNodesFunction {
        List<TreeNode> apply(TreeNode root, int[] toDelete);
    }

    private record TestCase(String name, Integer[] treeArray, int[] toDelete, List<Integer[]> expectedForestArrays) {
    }
}
