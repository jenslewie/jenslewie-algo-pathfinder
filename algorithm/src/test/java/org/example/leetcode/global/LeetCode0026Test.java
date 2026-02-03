package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 26: Remove Duplicates from Sorted Array")
class LeetCode0026Test {

    private static final LeetCode0026 SOLUTION = new LeetCode0026();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}")
    @MethodSource("testCases")
    void testRemoveDuplicates(String caseName, int[] nums, int expected) {
        int actual = SOLUTION.removeDuplicates(nums);
        assertEquals(expected, actual, () -> "Case '%s' failed. nums=%s"
                .formatted(caseName, Arrays.toString(nums)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new int[]{1, 1, 2}, 2),
                Arguments.of("example_2", new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5),
                Arguments.of("empty_array", new int[]{}, 0),
                Arguments.of("all_unique", new int[]{1, 2, 3, 4}, 4)
        );
    }
}
