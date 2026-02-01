package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 283: Move Zeroes")
class LeetCode0283Test {

    private static final LeetCode0283 LEET_CODE = new LeetCode0283();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}")
    @MethodSource("testCases")
    void testMoveZeroes(String caseName, int[] nums, int[] expected) {
        int[] input = Arrays.copyOf(nums, nums.length);
        LEET_CODE.moveZeroes(nums);
        assertArrayEquals(expected, nums, () -> "Case '%s' failed. Input nums: %s"
                .formatted(caseName, Arrays.toString(input)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new int[]{0, 1, 0, 3, 12},
                        new int[]{1, 3, 12, 0, 0}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new int[]{0},
                        new int[]{0})
        );
    }
}
