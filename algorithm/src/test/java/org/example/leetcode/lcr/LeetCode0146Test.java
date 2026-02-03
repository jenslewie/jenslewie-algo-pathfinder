package org.example.leetcode.lcr;

import org.example.leetcode.utility.ArrayUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LCR 146: Spiral Array")
class LeetCode0146Test {

    private static final LeetCode0146 SOLUTION = new LeetCode0146();

    @ParameterizedTest(name = "[{index}] case={0}")
    @MethodSource("testCases")
    void testSpiralArray(String caseName, int[][] matrix, int[] expected) {
        int[] actual = SOLUTION.spiralArray(matrix);
        assertArrayEquals(expected, actual, () -> "Case '%s' failed. Input matrix: %s"
                .formatted(caseName, ArrayUtility.matrixToString(matrix)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("empty_matrix",
                        new int[][]{},
                        new int[]{}),
                Arguments.of("empty_row",
                        new int[][]{{}},
                        new int[]{}),
                Arguments.of("3x3_matrix",
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}),
                Arguments.of("single_row",
                        new int[][]{{1, 2, 3, 4}},
                        new int[]{1, 2, 3, 4}),
                Arguments.of("single_column",
                        new int[][]{{1}, {2}, {3}, {4}},
                        new int[]{1, 2, 3, 4}),
                Arguments.of("single_cell",
                        new int[][]{{42}},
                        new int[]{42}),
                Arguments.of("2x3_matrix",
                        new int[][]{{1, 2, 3}, {4, 5, 6}},
                        new int[]{1, 2, 3, 6, 5, 4}),
                Arguments.of("3x2_matrix",
                        new int[][]{{1, 2}, {3, 4}, {5, 6}},
                        new int[]{1, 2, 4, 6, 5, 3}),
                Arguments.of("2x2_matrix",
                        new int[][]{{1, 2}, {3, 4}},
                        new int[]{1, 2, 4, 3}),
                Arguments.of("1x2_matrix",
                        new int[][]{{7, 8}},
                        new int[]{7, 8}),
                Arguments.of("2x1_matrix",
                        new int[][]{{7}, {8}},
                        new int[]{7, 8}),
                Arguments.of("4x4_matrix",
                        new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16})
        );
    }
}
