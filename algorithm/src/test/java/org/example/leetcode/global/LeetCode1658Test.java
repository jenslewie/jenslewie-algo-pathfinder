package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1658: Minimum Operations to Reduce X to Zero")
class LeetCode1658Test {

    private static final LeetCode1658 SOLUTION = new LeetCode1658();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}, x={2}")
    @MethodSource("testCases")
    void testMinOperations(String caseName, int[] nums, int x, int expected) {
        int actual = SOLUTION.minOperations(nums, x);
        assertEquals(expected, actual, () -> "Case '%s' failed. nums=%s, x=%d"
                .formatted(caseName, Arrays.toString(nums), x));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new int[]{1, 1, 4, 2, 3},
                        5,
                        2),

                // sum < x
                Arguments.of("sum_less_than_x",
                        new int[]{1, 1, 1},
                        5,
                        -1),

                // sum == x (remove all)
                Arguments.of("sum_equals_x",
                        new int[]{1, 2, 3},
                        6,
                        3),

                // No valid subarray (maxLen stays MIN)
                Arguments.of("no_valid_subarray",
                        new int[]{5, 6, 7, 8, 9},
                        4,
                        -1)
        );
    }
}
