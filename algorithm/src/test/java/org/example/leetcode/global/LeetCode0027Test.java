package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 27: Remove Element")
class LeetCode0027Test {

    private static final LeetCode0027 SOLUTION = new LeetCode0027();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}, val={2}")
    @MethodSource("testCases")
    void testRemoveElement(String caseName, int[] nums, int val, int expected) {
        int actual = SOLUTION.removeElement(nums, val);
        assertEquals(expected, actual, () -> "Case '%s' failed. nums=%s, val=%d"
                .formatted(caseName, Arrays.toString(nums), val));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new int[]{3, 2, 2, 3}, 3, 2),
                Arguments.of("example_2", new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5),
                Arguments.of("empty_array", new int[]{}, 1, 0),
                Arguments.of("no_removal", new int[]{1, 2, 3}, 4, 3),
                Arguments.of("all_removed", new int[]{2, 2, 2}, 2, 0)
        );
    }
}
