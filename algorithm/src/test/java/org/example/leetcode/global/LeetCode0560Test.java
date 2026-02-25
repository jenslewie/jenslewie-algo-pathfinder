package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 0560: Subarray Sum Equals K")
class LeetCode0560Test {

    private static final LeetCode0560_1 SOLUTION_1 = new LeetCode0560_1();
    private static final LeetCode0560_2 SOLUTION_2 = new LeetCode0560_2();
    private static final Map<String, SubarraySumFunction> ALGO_VARIANTS = Map.of(
            "bruteforce_iterative_traverse_with_end_index_enumeration", SOLUTION_1::subarraySum,
            "prefix_sum_iterative_traverse_with_hashmap", SOLUTION_2::subarraySum
    );

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.k, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new int[]{1, 1, 1}, 2, 2),
                new TestCase("example_2", new int[]{1, 2, 3}, 3, 2),

                // === Additional Coverage ===
                new TestCase("empty_array", new int[]{}, 0, 0),
                new TestCase("all_zeros", new int[]{0, 0, 0}, 0, 6),
                new TestCase("mixed_positive_negative", new int[]{1, -1, 0}, 0, 3),
                new TestCase("classic_prefix_sum_case", new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7, 4)
        );
    }

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, int[] nums, int k, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(nums, k);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums=%s, k=%d"
                .formatted(caseName, algoName, Arrays.toString(nums), k));
    }

    @FunctionalInterface
    interface SubarraySumFunction {
        int apply(int[] nums, int k);
    }

    private record TestCase(String name, int[] nums, int k, int expected) {
    }
}
