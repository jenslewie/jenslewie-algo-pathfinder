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

@DisplayName("LeetCode 222: Count Complete Tree Nodes")
class LeetCode0222Test {

    private static final LeetCode0222_1 SOLUTION_1 = new LeetCode0222_1();
    private static final LeetCode0222_2 SOLUTION_2 = new LeetCode0222_2();
    private static final LeetCode0222_3 SOLUTION_3 = new LeetCode0222_3();
    private static final LeetCode0222_4 SOLUTION_4 = new LeetCode0222_4();

    @FunctionalInterface
    interface CountNodesFunction {
        int apply(TreeNode root);
    }

    private static final Map<String, CountNodesFunction> ALGO_VARIANTS = Map.of(
            "bfs_iterative_traverse_queue", SOLUTION_1::countNodes,
            "dfs_recursive_traverse", SOLUTION_2::countNodes,
            "dfs_recursive_divide_conquer_with_height", SOLUTION_3::countNodes,
            "dfs_recursive_divide_conquer_with_perfect_subtree", SOLUTION_4::countNodes
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCountNodes(String caseName, String algoName, Integer[] treeArray, int expected) {
        TreeNode root = BinaryTreeBuilder.build(treeArray);
        int actual = ALGO_VARIANTS.get(algoName).apply(root);
        assertEquals(expected, actual,
                () -> String.format("Case '%s' failed for algo='%s'. Expected node count: %d", caseName, algoName, expected));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.treeArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("complete_last_level_left",
                        new Integer[]{1, 2, 3, 4, 5, 6},
                        6),

                new TestCase("single_node",
                        new Integer[]{1},
                        1),

                new TestCase("empty",
                        null,
                        0),

                // === Additional Coverage ===
                new TestCase("two_nodes_left_only",
                        new Integer[]{1, 2},
                        2),

                new TestCase("three_nodes_full",
                        new Integer[]{1, 2, 3},
                        3),

                new TestCase("perfect_tree_height_3",
                        new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        7)
        );
    }

    private record TestCase(String name, Integer[] treeArray, int expected) {
    }
}
