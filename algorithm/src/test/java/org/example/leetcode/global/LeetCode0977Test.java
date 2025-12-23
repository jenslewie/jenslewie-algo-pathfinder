package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 977: Squares of a Sorted Array - Algorithm Variants")
class LeetCode0977Test {

    private static final LeetCode0977 INSTANCE = new LeetCode0977();

    @FunctionalInterface
    interface SquareSquaresFunction {
        int[] apply(int[] nums);
    }

    private static final Map<String, SquareSquaresFunction> ALGO_VARIANTS = Map.of(
            "sortedSquares", INSTANCE::sortedSquares,
            "sortedSquares2", INSTANCE::sortedSquares2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testSortedSquares(String caseName, String algoName, int[] input, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(input.clone());

        assertArrayEquals(expected, actual,
                () -> "Case '%s' with algo '%s' failed on input %s".formatted(caseName, algoName, Arrays.toString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc ->
                ALGO_VARIANTS.keySet().stream().map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("mixed_negative_positive",
                        new int[]{-4, -1, 0, 3, 10},
                        new int[]{0, 1, 9, 16, 100}),

                new TestCase("all_negative",
                        new int[]{-7, -3, -1},
                        new int[]{1, 9, 49}),

                new TestCase("all_positive",
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1, 4, 9, 16, 25}),

                new TestCase("with_zero",
                        new int[]{-2, -1, 0, 1, 2},
                        new int[]{0, 1, 1, 4, 4}),

                new TestCase("single_element",
                        new int[]{5},
                        new int[]{25}),

                new TestCase("single_negative",
                        new int[]{-3},
                        new int[]{9}),

                new TestCase("duplicate_values",
                        new int[]{-2, -2, 2, 2},
                        new int[]{4, 4, 4, 4}),

                new TestCase("large_values",
                        new int[]{-10000, -1, 0, 1, 10000},
                        new int[]{0, 1, 1, 100000000, 100000000}),

                new TestCase("empty_array",
                        new int[]{},
                        new int[]{})
        );
    }

    private static class TestCase {
        final String name;
        final int[] input;
        final int[] expected;

        TestCase(String name, int[] input, int[] expected) {
            this.name = name;
            this.input = input.clone();
            this.expected = expected.clone();
        }
    }
}