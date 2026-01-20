package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 862: Shortest Subarray with Sum at Least K")
class LeetCode0862Test {

    private final LeetCode0862 solution = new LeetCode0862();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}, k={2}")
    @MethodSource("testCases")
    void testShortestSubarray(String caseName, int[] nums, int k, int expected) {
        int actual = solution.shortestSubarray(nums, k);
        assertEquals(expected, actual, () -> String.format(
                "Case '%s' failed. Input: nums=%s, k=%d",
                caseName, java.util.Arrays.toString(nums), k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode 862
                Arguments.of("example_1", new int[]{1}, 1, 1),

                // Example 2 from LeetCode 862
                Arguments.of("example_2", new int[]{1, 2}, 4, -1),

                // Example 3 from LeetCode 862
                Arguments.of("example_3", new int[]{2, -1, 2}, 3, 3),

                // Single element insufficient
                Arguments.of("single_insufficient", new int[]{2}, 3, -1),

                // All positive, exact match
                Arguments.of("all_positive_exact", new int[]{1, 2, 3, 4, 5}, 9, 2),

                // With negative numbers, optimal subarray in middle
                Arguments.of("with_negative", new int[]{3, -2, 5, -1, 2}, 6, 3),

                // Entire array sum equals k
                Arguments.of("entire_array", new int[]{1, -1, 1, -1, 1}, 1, 1),

                // No valid subarray
                Arguments.of("large_k", new int[]{1, 2, 3}, 10, -1),

                // All zeros, no solution
                Arguments.of("all_zeros", new int[]{0, 0, 0}, 1, -1),

                // Mix with zero
                Arguments.of("with_zero", new int[]{1, 0, 2, -1, 3}, 4, 3),

                // Negative prefix should be skipped
                Arguments.of("negative_prefix", new int[]{-1, -2, 3, 4}, 7, 2),

                // Large numbers
                Arguments.of("large_numbers", new int[]{1000000000, 1000000000}, 1000000000, 1)
        );
    }
}