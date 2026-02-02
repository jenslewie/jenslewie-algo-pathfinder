package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 209: Minimum Size Subarray Sum")
class LeetCode0209Test {

    private static final LeetCode0209 SOLUTION = new LeetCode0209();

    @ParameterizedTest(name = "[{index}] case={0}, target={1}, nums={2}")
    @MethodSource("testCases")
    void testMinSubArrayLen(String caseName, int target, int[] nums, int expected) {
        int actual = SOLUTION.minSubArrayLen(target, nums);
        assertEquals(expected, actual, () -> "Case '%s' failed. target=%d, nums=%s"
                .formatted(caseName, target, Arrays.toString(nums)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        7,
                        new int[]{2, 3, 1, 2, 4, 3},
                        2),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        4,
                        new int[]{1, 4, 4},
                        1),

                // Example 3 from LeetCode
                Arguments.of("example_3",
                        11,
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                        0)
        );
    }
}
