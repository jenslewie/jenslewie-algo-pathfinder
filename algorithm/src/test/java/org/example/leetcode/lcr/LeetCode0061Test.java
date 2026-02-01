package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 061: Find K Pairs with Smallest Sums")
class LeetCode0061Test {

    private static final LeetCode0061 LEET_CODE = new LeetCode0061();

    @ParameterizedTest(name = "[{index}] case={0}, nums1={1}, nums2={2}, k={3}")
    @MethodSource("testCases")
    void testKSmallestPairs(String caseName, int[] nums1, int[] nums2, int k, List<List<Integer>> expected) {
        List<List<Integer>> actual = LEET_CODE.kSmallestPairs(nums1, nums2, k);
        assertEquals(expected, actual,
                String.format("Case '%s' failed. nums1=%s, nums2=%s, k=%d",
                        caseName, Arrays.toString(nums1), Arrays.toString(nums2), k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3,
                        List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6))),
                Arguments.of("example_2", new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2,
                        List.of(List.of(1, 1), List.of(1, 1))),
                Arguments.of("k_exceeds", new int[]{1, 2}, new int[]{3}, 3,
                        List.of(List.of(1, 3), List.of(2, 3)))
        );
    }
}
