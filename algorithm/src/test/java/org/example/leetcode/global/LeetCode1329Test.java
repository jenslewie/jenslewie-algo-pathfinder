package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 1329: Sort the Matrix Diagonally - Algorithm Variants")
class LeetCode1329Test {

    private static final LeetCode1329 LEET_CODE = new LeetCode1329();

    @FunctionalInterface
    interface DiagonalSortFunction {
        int[][] apply(int[][] mat);
    }

    private static final Map<String, DiagonalSortFunction> ALGO_VARIANTS = Map.of(
            "diagonalSort", LEET_CODE::diagonalSort,
            "diagonalSort2", LEET_CODE::diagonalSort2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testDiagonalSort(String caseName, String algoName, int[][] input, int[][] expected) {
        int[][] actual = ALGO_VARIANTS.get(algoName).apply(deepClone(input));

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. Input matrix: %s"
                .formatted(caseName, algoName, matrixToString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc ->
                ALGO_VARIANTS.keySet().stream()
                        .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("example_1",
                        new int[][]{
                                {3, 3, 1, 1},
                                {2, 2, 1, 2},
                                {1, 1, 1, 2}
                        },
                        new int[][]{
                                {1, 1, 1, 1},
                                {1, 2, 2, 2},
                                {1, 2, 3, 3}
                        }),

                new TestCase("example_2",
                        new int[][]{
                                {11, 25, 66, 1, 69, 7},
                                {23, 55, 17, 45, 15, 52},
                                {75, 31, 36, 44, 58, 8},
                                {22, 27, 33, 25, 68, 4},
                                {84, 28, 14, 11, 5, 50}
                        },
                        new int[][]{
                                {5, 17, 4, 1, 52, 7},
                                {11, 11, 25, 45, 8, 69},
                                {14, 23, 25, 44, 58, 15},
                                {22, 27, 31, 36, 50, 66},
                                {84, 28, 75, 33, 55, 68}
                        }),

                new TestCase("single_row",
                        new int[][]{{5, 3, 1, 2}},
                        new int[][]{{5, 3, 1, 2}}),

                new TestCase("single_column",
                        new int[][]{{4}, {2}, {3}, {1}},
                        new int[][]{{4}, {2}, {3}, {1}}),

                new TestCase("2x2_matrix",
                        new int[][]{
                                {9, 8},
                                {7, 6}
                        },
                        new int[][]{
                                {6, 8},
                                {7, 9}
                        }),

                new TestCase("already_sorted",
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        }),

                new TestCase("1x1_matrix",
                        new int[][]{{42}},
                        new int[][]{{42}})
        );
    }

    private static int[][] deepClone(int[][] original) {
        return Arrays.stream(original)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    private static String matrixToString(int[][] mat) {
        if (mat == null) return "null";
        return Arrays.stream(mat)
                .map(Arrays::toString)
                .reduce((a, b) -> a + ", " + b)
                .map(s -> "[" + s + "]")
                .orElse("[]");
    }

    private record TestCase(String name, int[][] input, int[][] expected) {
        private TestCase(String name, int[][] input, int[][] expected) {
            this.name = name;
            this.input = deepClone(input);
            this.expected = deepClone(expected);
        }
    }
}