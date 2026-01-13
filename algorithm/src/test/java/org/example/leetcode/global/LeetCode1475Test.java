package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 1475: Final Prices With a Special Discount in a Shop")
class LeetCode1475Test {

    @FunctionalInterface
    interface FinalPricesFunction {
        int[] apply(int[] prices);
    }

    private static final Map<String, FinalPricesFunction> ALGO_VARIANTS = Map.of(
            "monotonic_stack_from_right", prices -> new LeetCode1475_1().finalPrices(copy(prices)),
            "monotonic_stack_from_left_modify_in_place", prices -> new LeetCode1475_2().finalPrices(copy(prices)),
            "brute_force", prices -> new LeetCode1475_3().finalPrices(copy(prices))
    );

    // Helper: deep copy array to avoid mutation side effects
    private static int[] copy(int[] arr) {
        return arr == null ? null : arr.clone();
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, prices={2}")
    @MethodSource("allCombinations")
    void testFinalPrices(String caseName, String algoName, int[] input, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(input);

        assertArrayEquals(expected, actual, () -> String.format("Case '%s' with algo='%s' failed. Input: %s",
                caseName, algoName, java.util.Arrays.toString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode 1475
                new TestCase("example_1", new int[]{8, 4, 6, 2, 3}, new int[]{4, 2, 4, 2, 3}),

                // Example 2 from LeetCode 1475
                new TestCase("example_2", new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),

                // Example 3 from LeetCode 1475
                new TestCase("example_3", new int[]{10, 1, 1, 6}, new int[]{9, 0, 1, 6}),

                // Single item
                new TestCase("single", new int[]{5}, new int[]{5}),

                // All equal
                new TestCase("all_equal", new int[]{3, 3, 3, 3}, new int[]{0, 0, 0, 3}),

                // Strictly decreasing
                new TestCase("strictly_decreasing", new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 1, 1, 1}),

                // Strictly increasing
                new TestCase("strictly_increasing", new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),

                // Complex case
                new TestCase("complex", new int[]{8, 7, 4, 2, 8, 1, 7, 7, 10, 1}, new int[]{1, 3, 2, 1, 7, 0, 0, 6, 9, 1})
        );
    }

    private record TestCase(String name, int[] input, int[] expected) {
    }

}
