package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 496: Next Greater Element I - Algorithm Variants")
class LeetCode0496Test {

    private static final LeetCode0496_1 SOLUTION_1 = new LeetCode0496_1();
    private static final LeetCode0496_2 SOLUTION_2 = new LeetCode0496_2();

    @FunctionalInterface
    interface NextGreaterElementFunction {
        int[] apply(int[] nums1, int[] nums2);
    }

    private static final Map<String, NextGreaterElementFunction> ALGO_VARIANTS = Map.of(
            "monotonic_stack_right_to_left", SOLUTION_1::nextGreaterElement,
            "monotonic_stack_left_to_right", SOLUTION_2::nextGreaterElement
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums1={2}, nums2={3}")
    @MethodSource("allCombinations")
    void testNextGreaterElement(String caseName, String algoName, int[] nums1, int[] nums2, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(nums1, nums2);

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums1=%s, nums2=%s"
                .formatted(caseName, algoName, Arrays.toString(nums1), Arrays.toString(nums2)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums1, tc.nums2, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new int[]{4, 1, 2},
                        new int[]{1, 3, 4, 2},
                        new int[]{-1, 3, -1}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{2, 4},
                        new int[]{1, 2, 3, 4},
                        new int[]{3, -1}),

                // Single element
                new TestCase("single_element",
                        new int[]{1},
                        new int[]{1},
                        new int[]{-1}),

                // All elements have next greater
                new TestCase("all_have_greater",
                        new int[]{1, 2, 3},
                        new int[]{1, 2, 3, 4},
                        new int[]{2, 3, 4}),

                // No elements have next greater
                new TestCase("none_have_greater",
                        new int[]{4, 3, 2},
                        new int[]{4, 3, 2, 1},
                        new int[]{-1, -1, -1}),

                // nums1 not in order of nums2
                new TestCase("unordered_nums1",
                        new int[]{3, 1},
                        new int[]{1, 2, 3},
                        new int[]{-1, 2}),

                // Duplicate values (though problem states distinct)
                new TestCase("distinct_values_only",
                        new int[]{1, 2},
                        new int[]{2, 1, 3},
                        new int[]{3, 3}),

                // Large values
                new TestCase("large_values",
                        new int[]{1000000000},
                        new int[]{1, 1000000000, 2},
                        new int[]{-1}),

                // Large values
                new TestCase("specified_values",
                        new int[]{1, 2, 3},
                        new int[]{2, 1, 2, 4, 3},
                        new int[]{2, 4, -1})
        );
    }

    private record TestCase(String name, int[] nums1, int[] nums2, int[] expected) {
    }

}