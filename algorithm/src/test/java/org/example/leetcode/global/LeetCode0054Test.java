package org.example.leetcode.global;

import org.example.leetcode.utility.ArrayUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 54: Spiral Matrix")
class LeetCode0054Test {

    private static final LeetCode0054 SOLUTION = new LeetCode0054();

    @ParameterizedTest(name = "[{index}] case={0}")
    @MethodSource("testCases")
    void testSpiralOrder(String caseName, int[][] matrix, List<Integer> expected) {
        List<Integer> actual = SOLUTION.spiralOrder(matrix);
        assertEquals(expected, actual, () -> "Case '%s' failed. Input matrix: %s"
                .formatted(caseName, ArrayUtility.matrixToString(matrix)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("3x3_matrix",
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Arguments.of("3x4_matrix",
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
                Arguments.of("4x4_matrix",
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10))
        );
    }
}
