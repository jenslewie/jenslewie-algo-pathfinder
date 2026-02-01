package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 713: Subarray Product Less Than K")
class LeetCode0713Test {

    private static final LeetCode0713 LEET_CODE = new LeetCode0713();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}, k={2}")
    @MethodSource("testCases")
    void testNumSubarrayProductLessThanK(String caseName, int[] nums, int k, int expected) {
        int actual = LEET_CODE.numSubarrayProductLessThanK(nums, k);
        assertEquals(expected, actual, () -> "Case '%s' failed. nums=%s, k=%d"
                .formatted(caseName, Arrays.toString(nums), k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new int[]{10, 5, 2, 6},
                        100,
                        8),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new int[]{1, 2, 3},
                        0,
                        0)
        );
    }
}
