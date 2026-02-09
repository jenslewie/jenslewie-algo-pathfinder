package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 136: Single Number - Algorithm Variants")
class LeetCode0136Test {

    private static final LeetCode0136 SOLUTION_1 = new LeetCode0136();

    @FunctionalInterface
    interface SingleNumberFunction {
        int apply(int[] nums);
    }

    private static final Map<String, SingleNumberFunction> ALGO_VARIANTS = Map.of(
            "bitwise_iterative_xor", SOLUTION_1::singleNumber
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int[] nums, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(nums);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums=%s"
                .formatted(caseName, algoName, Arrays.toString(nums)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new int[]{2, 2, 1}, 1),
                new TestCase("example_2", new int[]{4, 1, 2, 1, 2}, 4),
                new TestCase("example_3", new int[]{1}, 1),

                // === Additional Coverage ===
                new TestCase("negative_unique", new int[]{-1, 2, 2}, -1),
                new TestCase("zero_unique", new int[]{0, 7, 7}, 0),
                new TestCase("mixed_signs", new int[]{-3, -3, 9, 8, 8}, 9),
                new TestCase("min_int_unique", new int[]{Integer.MIN_VALUE, 5, 5}, Integer.MIN_VALUE)
        );
    }

    private record TestCase(String name, int[] nums, int expected) {
    }
}
