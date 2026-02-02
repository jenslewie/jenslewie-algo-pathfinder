package org.example.leetcode.global;

import org.example.leetcode.utility.ArrayUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 867: Transpose Matrix - Algorithm Variants")
class LeetCode0867Test {

    private static final LeetCode0867 SOLUTION = new LeetCode0867();

    @FunctionalInterface
    interface TransposeFunction {
        int[][] apply(int[][] matrix);
    }

    private static final Map<String, TransposeFunction> ALGO_VARIANTS = Map.of(
            "transpose", SOLUTION::transpose
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, matrix={2}")
    @MethodSource("allCombinations")
    void testTranspose(String caseName, String algoName, int[][] input, int[][] expected) {
        int[][] actual = ALGO_VARIANTS.get(algoName).apply(input);

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. Input matrix: %s"
                .formatted(caseName, algoName, ArrayUtility.matrixToString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("rectangular_3x2",
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6}
                        },
                        new int[][]{
                                {1, 4},
                                {2, 5},
                                {3, 6}
                        }),

                // Example 2 from LeetCode
                new TestCase("square_2x2",
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        new int[][]{
                                {1, 3},
                                {2, 4}
                        }),

                // Single row → single column
                new TestCase("single_row",
                        new int[][]{{1, 2, 3, 4}},
                        new int[][]{
                                {1},
                                {2},
                                {3},
                                {4}
                        }),

                // Single column → single row
                new TestCase("single_column",
                        new int[][]{
                                {10},
                                {20},
                                {30}
                        },
                        new int[][]{{10, 20, 30}}),

                // 1x1 matrix
                new TestCase("single_element",
                        new int[][]{{42}},
                        new int[][]{{42}}),

                // Larger rectangular matrix
                new TestCase("4x3_to_3x4",
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        new int[][]{
                                {1, 5, 9},
                                {2, 6, 10},
                                {3, 7, 11},
                                {4, 8, 12}
                        }),

                // Matrix with negative numbers
                new TestCase("with_negatives",
                        new int[][]{
                                {-1, 0},
                                {1, 2}
                        },
                        new int[][]{
                                {-1, 1},
                                {0, 2}
                        })
        );
    }

    private record TestCase(String name, int[][] input, int[][] expected) {
    }

}