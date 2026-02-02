package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 008: Minimum Size Subarray Sum")
class LeetCode0008Test {

    private static final LeetCode0008 SOLUTION = new LeetCode0008();

    @ParameterizedTest(name = "[{index}] case={0}, target={1}, nums={2}")
    @MethodSource("testCases")
    void testMinSubArrayLen(String caseName, int target, int[] nums, int expected) {
        int actual = SOLUTION.minSubArrayLen(target, nums);
        assertEquals(expected, actual, () -> "Case '%s' failed. target=%d, nums=%s"
                .formatted(caseName, target, Arrays.toString(nums)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", 7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                Arguments.of("example_2", 4, new int[]{1, 4, 4}, 1),
                Arguments.of("not_found", 11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0)
        );
    }
}
