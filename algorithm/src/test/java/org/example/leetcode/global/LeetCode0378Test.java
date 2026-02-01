package org.example.leetcode.global;

import org.example.leetcode.utility.ArrayUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 378: Kth Smallest Element in a Sorted Matrix")
class LeetCode0378Test {

    private static final LeetCode0378 LEET_CODE = new LeetCode0378();

    @ParameterizedTest(name = "[{index}] case={0}, matrix={1}, k={2}")
    @MethodSource("testCases")
    void testKthSmallest(String caseName, int[][] matrix, int k, int expected) {
        int actual = LEET_CODE.kthSmallest(matrix, k);
        assertEquals(expected, actual, () -> "Case '%s' failed. matrix=%s, k=%d"
                .formatted(caseName, ArrayUtility.matrixToString(matrix), k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("3x3_matrix", new int[][]{{1, 5, 9}, {10, 11, 13}, {10, 12, 15}}, 8, 13),
                Arguments.of("single_element", new int[][]{{-5}}, 1, -5)
        );
    }
}
