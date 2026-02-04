package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 057: Contains Duplicate III")
class LCR0057Test {

    private static final LCR0057 SOLUTION = new LCR0057();

    @ParameterizedTest(name = "[{index}] case={0}, nums={1}, k={2}, t={3}")
    @MethodSource("testCases")
    void testContainsNearbyAlmostDuplicate(String caseName, int[] nums, int k, int t, boolean expected) {
        boolean actual = SOLUTION.containsNearbyAlmostDuplicate(nums, k, t);
        assertEquals(expected, actual, () -> "Case '%s' failed. nums=%s, k=%d, t=%d"
                .formatted(caseName, Arrays.toString(nums), k, t));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new int[]{1, 2, 3, 1}, 3, 0, true),
                Arguments.of("example_2", new int[]{1, 0, 1, 1}, 1, 2, true),
                Arguments.of("not_found", new int[]{1, 5, 9, 1, 5, 9}, 2, 3, false)
        );
    }
}
