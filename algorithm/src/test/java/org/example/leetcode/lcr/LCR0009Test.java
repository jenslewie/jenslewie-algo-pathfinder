package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 009: Subarray Product Less Than K")
class LCR0009Test {

    private static final LCR0009 SOLUTION = new LCR0009();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}, k={2}")
    @MethodSource("testCases")
    void testNumSubarrayProductLessThanK(String caseName, int[] nums, int k, int expected) {
        int actual = SOLUTION.numSubarrayProductLessThanK(nums, k);
        assertEquals(expected, actual, () -> "Case '%s' failed. nums=%s, k=%d"
                .formatted(caseName, Arrays.toString(nums), k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of("k_zero", new int[]{1, 2, 3}, 0, 0)
        );
    }
}
