package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 704: Binary Search - Algorithm Variants")
class LeetCode0704Test {

    private static final LeetCode0704 LEET_CODE = new LeetCode0704();

    @FunctionalInterface
    interface SearchFunction {
        int apply(int[] nums, int target);
    }

    private static final Map<String, SearchFunction> ALGO_VARIANTS = Map.of(
            "binary_search", LEET_CODE::search
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, target={3}")
    @MethodSource("allCombinations")
    void testSearch(String caseName, String algoName, int[] nums, int target, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(nums, target);

        assertEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. nums=%s, target=%d"
                .formatted(caseName, algoName, java.util.Arrays.toString(nums), target));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.target, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("target_exists",
                        new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),

                // Example 2 from LeetCode
                new TestCase("target_not_exists",
                        new int[]{-1, 0, 3, 5, 9, 12}, 2, -1),

                // Target at beginning
                new TestCase("target_at_start",
                        new int[]{1, 2, 3, 4, 5}, 1, 0),

                // Target at end
                new TestCase("target_at_end",
                        new int[]{1, 2, 3, 4, 5}, 5, 4),

                // Single element exists
                new TestCase("single_element_match",
                        new int[]{7}, 7, 0),

                // Single element not exists
                new TestCase("single_element_mismatch",
                        new int[]{7}, 5, -1),

                // All negative numbers
                new TestCase("all_negative",
                        new int[]{-10, -5, -3, -1}, -5, 1),

                // Target smaller than all
                new TestCase("target_too_small",
                        new int[]{1, 2, 3, 4, 5}, 0, -1),

                // Target larger than all
                new TestCase("target_too_large",
                        new int[]{1, 2, 3, 4, 5}, 6, -1),

                // Two elements: match first
                new TestCase("two_elements_first",
                        new int[]{10, 20}, 10, 0),

                // Two elements: match second
                new TestCase("two_elements_second",
                        new int[]{10, 20}, 20, 1),

                // Two elements: no match
                new TestCase("two_elements_no_match",
                        new int[]{10, 20}, 15, -1)
        );
    }

    private record TestCase(String name, int[] nums, int target, int expected) {
    }

}