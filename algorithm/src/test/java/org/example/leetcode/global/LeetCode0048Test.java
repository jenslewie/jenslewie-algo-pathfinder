package org.example.leetcode.global;

import org.example.leetcode.utility.ArrayUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 48: Rotate Image")
class LeetCode0048Test {

    private static final LeetCode0048 SOLUTION = new LeetCode0048();

    @ParameterizedTest(name = "[{index}] case={0}, matrix={1}")
    @MethodSource("testCases")
    void testRotate(String caseName, int[][] matrix, int[][] expected) {
        int[][] input = ArrayUtility.deepClone(matrix);
        SOLUTION.rotate(matrix);
        assertArrayEquals(expected, matrix, () -> "Case '%s' failed. Input matrix: %s"
                .formatted(caseName, ArrayUtility.matrixToString(input)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}},
                        new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}})
        );
    }
}
