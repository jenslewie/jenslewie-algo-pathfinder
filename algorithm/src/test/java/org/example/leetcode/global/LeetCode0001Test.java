package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 1: Two Sum - Algorithm Variants")
class LeetCode0001Test {

    private static final LeetCode0001 SOLUTION = new LeetCode0001();

    @FunctionalInterface
    interface TwoSumFunction {
        int[] apply(int[] nums, int target);
    }

    private static final Map<String, TwoSumFunction> ALGO_VARIANTS = Map.of(
            "hash_map", SOLUTION::twoSum
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, target={3}")
    @MethodSource("allCombinations")
    void testTwoSum(String caseName, String algoName, int[] nums, int target, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(nums, target);

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums=%s, target=%d"
                .formatted(caseName, algoName, Arrays.toString(nums), target));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.target, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new int[]{2, 7, 11, 15},
                        9,
                        new int[]{1, 0}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{3, 2, 4},
                        6,
                        new int[]{2, 1}),

                // Example 3 from LeetCode
                new TestCase("example_3",
                        new int[]{3, 3},
                        6,
                        new int[]{1, 0}),

                // Two elements at beginning
                new TestCase("two_at_start",
                        new int[]{1, 2, 3, 4, 5},
                        3,
                        new int[]{1, 0}),

                // Two elements at end
                new TestCase("two_at_end",
                        new int[]{1, 2, 3, 4, 5},
                        9,
                        new int[]{4, 3}),

                // Negative numbers
                new TestCase("negative_numbers",
                        new int[]{-1, -2, -3, -4, -5},
                        -8,
                        new int[]{4, 2}),

                // Mixed positive and negative
                new TestCase("mixed_numbers",
                        new int[]{-3, 4, 3, 90},
                        0,
                        new int[]{2, 0}),

                // Large numbers
                new TestCase("large_numbers",
                        new int[]{1000000, 2000000, 3000000},
                        5000000,
                        new int[]{2, 1}),

                // Zero in array
                new TestCase("with_zero",
                        new int[]{0, 4, 3, 0},
                        0,
                        new int[]{3, 0})
        );
    }

    private record TestCase(String name, int[] nums, int target, int[] expected) {
    }

}
