package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 59: Spiral Matrix II")
class LeetCode0059Test {

    private static final LeetCode0059 SOLUTION = new LeetCode0059();

    @ParameterizedTest(name = "[{index}] case={0}, n={1}")
    @MethodSource("testCases")
    void testGenerateMatrix(String caseName, int n, int[][] expected) {
        int[][] actual = SOLUTION.generateMatrix(n);
        assertArrayEquals(expected, actual, () -> "Case '%s' failed. n=%d"
                .formatted(caseName, n));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        3,
                        new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        1,
                        new int[][]{{1}}),

                // Example 2b: n = 2
                Arguments.of("n_2",
                        2,
                        new int[][]{{1, 2}, {4, 3}}),

                // Example 3: n = 4
                Arguments.of("example_3",
                        4,
                        new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}})
        );
    }
}
