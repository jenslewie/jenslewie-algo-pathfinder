package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 581: Shortest Unsorted Continuous Subarray")
class LeetCode0581Test {

    private final LeetCode0581 solution = new LeetCode0581();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}")
    @MethodSource("testCases")
    void testFindUnsortedSubarray(String caseName, int[] nums, int expected) {
        int actual = solution.findUnsortedSubarray(nums);
        assertEquals(expected, actual, () -> String.format(
                "Case '%s' failed. Input: %s", caseName, java.util.Arrays.toString(nums)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode 581
                Arguments.of("example_1", new int[]{2, 6, 4, 8, 10, 9, 15}, 5),

                // Example 2 from LeetCode 581
                Arguments.of("example_2", new int[]{1, 2, 3, 4}, 0),

                // Example 3 from LeetCode 581
                Arguments.of("example_3", new int[]{1}, 0),

                // Entire array is unsorted
                Arguments.of("entire_unsorted", new int[]{5, 4, 3, 2, 1}, 5),

                // Sorted in descending then ascending (valley)
                Arguments.of("valley", new int[]{3, 2, 1, 2, 3}, 4),

                // Only two elements swapped at ends
                Arguments.of("swap_ends", new int[]{5, 1, 2, 3, 4}, 5),

                // Duplicate values
                Arguments.of("with_duplicates", new int[]{1, 3, 2, 2, 2}, 4),

                // Already sorted with duplicates
                Arguments.of("sorted_with_duplicates", new int[]{1, 2, 2, 3, 3}, 0),

                // Single inversion in middle
                Arguments.of("single_inversion", new int[]{1, 3, 2, 4, 5}, 2),

                // All equal
                Arguments.of("all_equal", new int[]{2, 2, 2, 2}, 0),

                // Two elements: sorted
                Arguments.of("two_sorted", new int[]{1, 2}, 0),

                // Two elements: unsorted
                Arguments.of("two_unsorted", new int[]{2, 1}, 2)
        );
    }

}
