package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 167: Two Sum II - Input Array Is Sorted")
class LeetCode0167Test {

    private static final LeetCode0167 LEET_CODE = new LeetCode0167();

    @ParameterizedTest(name = "[{index}] case={0}, numbers={1}, target={2}")
    @MethodSource("testCases")
    void testTwoSum(String caseName, int[] numbers, int target, int[] expected) {
        int[] actual = LEET_CODE.twoSum(numbers, target);
        assertArrayEquals(expected, actual, () -> "Case '%s' failed. numbers=%s, target=%d"
                .formatted(caseName, Arrays.toString(numbers), target));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of("example_2", new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of("example_3", new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}
