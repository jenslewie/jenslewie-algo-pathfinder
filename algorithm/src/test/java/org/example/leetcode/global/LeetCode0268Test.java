package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0268: Missing Number")
class LeetCode0268Test {

    private static final LeetCode0268_1 SOLUTION_1 = new LeetCode0268_1();
    private static final LeetCode0268_2 SOLUTION_2 = new LeetCode0268_2();

    @FunctionalInterface
    interface MissingNumberFunction {
        int apply(int[] nums);
    }

    private static final Map<String, MissingNumberFunction> ALGO_VARIANTS = Map.of(
            "bitwise_iterative_xor", SOLUTION_1::missingNumber,
            "math_iterative_arithmetic_sum", SOLUTION_2::missingNumber
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
                new TestCase("example_1", new int[]{3, 0, 1}, 2),
                new TestCase("example_2", new int[]{0, 1}, 2),
                new TestCase("example_3", new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8),

                // === Additional Coverage ===
                new TestCase("missing_zero", new int[]{1}, 0),
                new TestCase("missing_n", new int[]{0}, 1),
                new TestCase("empty_array", new int[]{}, 0)
        );
    }

    private record TestCase(String name, int[] nums, int expected) {
    }
}
