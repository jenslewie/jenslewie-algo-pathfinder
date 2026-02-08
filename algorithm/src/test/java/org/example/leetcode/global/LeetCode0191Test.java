package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 191: Number of 1 Bits - Algorithm Variants")
class LeetCode0191Test {

    private static final LeetCode0191_1 SOLUTION_1 = new LeetCode0191_1();
    private static final LeetCode0191_2 SOLUTION_2 = new LeetCode0191_2();

    @FunctionalInterface
    interface HammingWeightFunction {
        int apply(int n);
    }

    private static final Map<String, HammingWeightFunction> ALGO_VARIANTS = Map.of(
            "bitwise_iterative_shift", SOLUTION_1::hammingWeight,
            "bitwise_iterative_kernighan", SOLUTION_2::hammingWeight
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, n={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int n, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(n);
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
                new TestCase("example_1", 11, 3),
                new TestCase("example_2", 128, 1),
                new TestCase("example_3", -3, 31),

                // === Additional Coverage ===
                new TestCase("zero", 0, 0),
                new TestCase("single_one", 1, 1),
                new TestCase("all_ones", -1, 32),
                new TestCase("min_value", Integer.MIN_VALUE, 1)
        );
    }

    private record TestCase(String name, int n, int expected) {
    }
}
