package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 128: Longest Consecutive Sequence")
class LeetCode0128Test {

    private static final LeetCode0128 SOLUTION = new LeetCode0128();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}")
    @MethodSource("testCases")
    void testLongestConsecutive(String caseName, int[] nums, int expected) {
        int actual = SOLUTION.longestConsecutive(nums);
        assertEquals(expected, actual, () -> "Case '" + caseName + "' failed.");
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1: [100,4,200,1,3,2] → [1,2,3,4] → length=4
                Arguments.of("example_1", new int[]{100, 4, 200, 1, 3, 2}, 4),

                // Example 2: [0,3,7,2,5,8,4,6,0,1] → [0,1,2,3,4,5,6,7,8] → length=9
                Arguments.of("example_2", new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),

                // Empty array
                Arguments.of("empty_array", new int[]{}, 0),

                // Single element
                Arguments.of("single_element", new int[]{1}, 1),

                // All same elements
                Arguments.of("all_same", new int[]{1, 1, 1, 1}, 1),

                // No consecutive sequence
                Arguments.of("no_consecutive", new int[]{1, 3, 5, 7}, 1),

                // Negative numbers
                Arguments.of("negative_numbers", new int[]{-1, -2, -3, 0, 1}, 5),

                // Mixed positive/negative
                Arguments.of("mixed_signs", new int[]{-2, -1, 0, 1, 3, 4, 5}, 4),

                // Two separate sequences
                Arguments.of("two_sequences", new int[]{1, 2, 3, 10, 11, 12, 13}, 4),

                // Large gap
                Arguments.of("large_gap", new int[]{1, 1000000}, 1),

                // Already sorted
                Arguments.of("sorted", new int[]{1, 2, 3, 4, 5}, 5),

                // Reverse sorted
                Arguments.of("reverse_sorted", new int[]{5, 4, 3, 2, 1}, 5)
        );
    }
}