package org.example.leetcode.global;

import org.example.builder.BinaryTreeBuilder;
import org.example.leetcode.utility.BinaryTreeUtility;
import org.example.model.tree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 654: Maximum Binary Tree")
class LeetCode0654Test {

    @FunctionalInterface
    interface ConstructMaxTreeFunction {
        TreeNode apply(int[] nums);
    }

    // Naming: [recursive/iterative]_[divide_conquer/monotonic_stack]_with_[metadata]
    private static final Map<String, ConstructMaxTreeFunction> ALGO_VARIANTS = Map.of(
            "recursive_divide_conquer_with_linear_scan",
            nums -> new LeetCode0654_1().constructMaximumBinaryTree(nums),

            "iterative_monotonic_stack_with_deque",
            nums -> new LeetCode0654_2().constructMaximumBinaryTree(nums)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}")
    @MethodSource("allCombinations")
    void testConstructMaximumBinaryTree(String caseName, String algoName, int[] input, Integer[] expectedTree) {
        TreeNode actual = ALGO_VARIANTS.get(algoName).apply(input);
        TreeNode expected = BinaryTreeBuilder.build(expectedTree);
        assertTrue(BinaryTreeUtility.isSameTree(expected, actual),
                () -> String.format("Case '%s' with algo='%s' failed.", caseName, algoName));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1: [3,2,1,6,0,5] -> [6,3,5,null,2,0,null,null,1]
                new TestCase("example_1",
                        new int[]{3, 2, 1, 6, 0, 5},
                        new Integer[]{6, 3, 5, null, 2, 0, null, null, null, null, 1}),

                // Example 2: [3,2,1] -> [3,null,2,null,1]
                new TestCase("example_2",
                        new int[]{3, 2, 1},
                        new Integer[]{3, null, 2, null, null, null, 1}),

                // Single element
                new TestCase("single_element",
                        new int[]{1},
                        new Integer[]{1}),

                // Two elements: [1,2] -> [2,1]
                new TestCase("two_elements_asc",
                        new int[]{1, 2},
                        new Integer[]{2, 1}),

                // Two elements: [2,1] -> [2,null,1]
                new TestCase("two_elements_desc",
                        new int[]{2, 1},
                        new Integer[]{2, null, 1}),

                // Strictly increasing: [1,2,3,4] -> [4,3,null,2,null,1]
                new TestCase("strictly_increasing",
                        new int[]{1, 2, 3, 4},
                        new Integer[]{4, 3, null, 2, null, null, null, 1}),

                // Strictly decreasing: [4,3,2,1] -> [4,null,3,null,2,null,1]
                new TestCase("strictly_decreasing",
                        new int[]{4, 3, 2, 1},
                        new Integer[]{4, null, 3, null, null, null, 2, null, null, null, null, null, null, null, 1})
        );
    }

    private record TestCase(String name, int[] input, Integer[] expected) {
    }

}
