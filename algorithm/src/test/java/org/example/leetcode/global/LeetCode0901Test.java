package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 901: Online Stock Span - Algorithm Variants")
class LeetCode0901Test {

    @FunctionalInterface
    interface StockSpanSimulator {
        int[] simulate(int[] prices);
    }

    private static final Map<String, StockSpanSimulator> ALGO_VARIANTS = Map.of(
            "span_with_count_merge", prices -> {
                LeetCode0901_1 algo = new LeetCode0901_1();
                return simulate(algo::next, prices);
            },
            "span_with_day_index", prices -> {
                LeetCode0901_2 algo = new LeetCode0901_2();
                return simulate(algo::next, prices);
            }
    );

    private static int[] simulate(Function<Integer, Integer> nextFunc, int[] prices) {
        int[] results = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            results[i] = nextFunc.apply(prices[i]);
        }
        return results;
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, input={2}")
    @MethodSource("allCombinations")
    void testStockSpan(String caseName, String algoName, int[] inputPrices, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).simulate(inputPrices);

        assertArrayEquals(expected, actual, () -> String.format(
                "Case '%s' with algo='%s' failed. Input prices: %s",
                caseName, algoName, java.util.Arrays.toString(inputPrices)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.inputPrices, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example from LeetCode 901
                new TestCase("example_1", new int[]{100, 80, 60, 70, 60, 75, 85}, new int[]{1, 1, 1, 2, 1, 4, 6}),

                // Single call
                new TestCase("single", new int[]{1000}, new int[]{1}),

                // Strictly decreasing
                new TestCase("strictly_decreasing", new int[]{100, 90, 80, 70}, new int[]{1, 1, 1, 1}),

                // Strictly increasing
                new TestCase("strictly_increasing", new int[]{70, 80, 90, 100}, new int[]{1, 2, 3, 4}),

                // All equal
                new TestCase("all_equal", new int[]{50, 50, 50, 50}, new int[]{1, 2, 3, 4}),

                // Complex fluctuation
                new TestCase("complex", new int[]{29, 91, 62, 76, 51}, new int[]{1, 2, 1, 2, 1})
        );
    }

    private record TestCase(String name, int[] inputPrices, int[] expected) {}

}
