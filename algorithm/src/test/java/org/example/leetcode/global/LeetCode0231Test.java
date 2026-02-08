package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 231: Power of Two")
class LeetCode0231Test {

    private static final LeetCode0231 SOLUTION_1 = new LeetCode0231();

    @FunctionalInterface
    interface PowerOfTwoFunction {
        boolean apply(int n);
    }

    private static final Map<String, PowerOfTwoFunction> ALGO_VARIANTS = Map.of(
            "bit_manipulation", SOLUTION_1::isPowerOfTwo
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, n={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int n, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(n);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. n=%d"
                .formatted(caseName, algoName, n));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.n, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", 1, true),   // 2^0 = 1
                new TestCase("example_2", 16, true),  // 2^4 = 16
                new TestCase("example_3", 3, false),

                // === Powers of Two ===
                new TestCase("power_of_two_0", 1, true),    // 2^0
                new TestCase("power_of_two_1", 2, true),    // 2^1
                new TestCase("power_of_two_2", 4, true),    // 2^2
                new TestCase("power_of_two_3", 8, true),    // 2^3
                new TestCase("power_of_two_4", 16, true),   // 2^4
                new TestCase("power_of_two_5", 32, true),   // 2^5
                new TestCase("power_of_two_10", 1024, true), // 2^10
                new TestCase("power_of_two_30", 1073741824, true), // 2^30

                // === Additional Coverage ===
                new TestCase("zero", 0, false),
                new TestCase("negative", -1, false),
                new TestCase("negative_power", -16, false),
                new TestCase("three", 3, false),
                new TestCase("five", 5, false),
                new TestCase("six", 6, false),
                new TestCase("seven", 7, false),
                new TestCase("nine", 9, false),
                new TestCase("ten", 10, false),
                new TestCase("fifteen", 15, false),
                new TestCase("seventeen", 17, false),
                new TestCase("max_int", Integer.MAX_VALUE, false),
                new TestCase("max_int_minus_one", Integer.MAX_VALUE - 1, false)
        );
    }

    private record TestCase(String name, int n, boolean expected) {
    }
}