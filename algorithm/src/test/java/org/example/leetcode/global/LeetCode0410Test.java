package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 410: Split Array Largest Sum - Algorithm Variants")
class LeetCode0410Test {

    private static final LeetCode0410 LEET_CODE = new LeetCode0410();

    @FunctionalInterface
    interface SplitArrayFunction {
        int apply(int[] nums, int k);
    }

    private static final Map<String, SplitArrayFunction> ALGO_VARIANTS = Map.of(
            "binary_search_v1", LEET_CODE::splitArray,
            "binary_search_v2", LEET_CODE::splitArray2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, k={3}")
    @MethodSource("allCombinations")
    void testSplitArray(String caseName, String algoName, int[] nums, int k, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(nums, k);

        assertEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. nums=%s, k=%d"
                .formatted(caseName, algoName, java.util.Arrays.toString(nums), k));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.k, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new int[]{7, 2, 5, 10, 8}, 2, 18),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{1, 2, 3, 4, 5}, 2, 9),

                // Example 3 from LeetCode
                new TestCase("example_3",
                        new int[]{1, 4, 4}, 3, 4),

                // k = 1 → sum of all
                new TestCase("k_equals_1",
                        new int[]{1, 2, 3, 4, 5}, 1, 15),

                // k = nums.length → max element
                new TestCase("k_equals_length",
                        new int[]{10, 20, 30, 40}, 4, 40),

                // Single element
                new TestCase("single_element",
                        new int[]{100}, 1, 100),

                // All elements same
                new TestCase("uniform_elements",
                        new int[]{5, 5, 5, 5}, 2, 10), // [5,5] + [5,5] → max=10

                // Large numbers
                new TestCase("large_values",
                        new int[]{1000000, 1000000, 1000000}, 2, 2000000),

                // k just enough to isolate max
                new TestCase("isolate_max",
                        new int[]{1, 1, 1, 100, 1, 1}, 2, 102), // [1,1,1] + [100,1,1] → 102

                // Minimal case
                new TestCase("minimal_case",
                        new int[]{1}, 1, 1)
        );
    }

    private record TestCase(String name, int[] nums, int k, int expected) {
    }

}