package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 239: Sliding Window Maximum - Algorithm Variants")
class LeetCode0239Test {

    private static final LeetCode0239_1 SOLUTION_1 = new LeetCode0239_1();
    private static final LeetCode0239_2 SOLUTION_2 = new LeetCode0239_2();

    @FunctionalInterface
    interface MaxSlidingWindowFunction {
        int[] apply(int[] nums, int k);
    }

    private static final Map<String, MaxSlidingWindowFunction> ALGO_VARIANTS = Map.of(
            "monotonic_deque", SOLUTION_1::maxSlidingWindow,
            "priority_queue", SOLUTION_2::maxSlidingWindow
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, k={3}")
    @MethodSource("allCombinations")
    void testMaxSlidingWindow(String caseName, String algoName, int[] nums, int k, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(nums, k);

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums=%s, k=%d"
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
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3,
                        new int[]{3, 3, 5, 5, 6, 7}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{1}, 1,
                        new int[]{1}),

                // k equals array length
                new TestCase("k_equals_length",
                        new int[]{1, -1}, 2,
                        new int[]{1}),

                // Monotonically increasing
                new TestCase("increasing",
                        new int[]{1, 2, 3, 4, 5}, 2,
                        new int[]{2, 3, 4, 5}),

                // Monotonically decreasing
                new TestCase("decreasing",
                        new int[]{5, 4, 3, 2, 1}, 2,
                        new int[]{5, 4, 3, 2}),

                // All same
                new TestCase("all_same",
                        new int[]{2, 2, 2, 2}, 3,
                        new int[]{2, 2}),

                // Negative numbers
                new TestCase("negative_numbers",
                        new int[]{-1, -2, -3, -4}, 2,
                        new int[]{-1, -2, -3}),

                // Large values
                new TestCase("large_values",
                        new int[]{1000000000, -1000000000, 1000000000}, 2,
                        new int[]{1000000000, 1000000000}),

                // k = 1 (each element is window)
                new TestCase("k_equals_1",
                        new int[]{1, 3, 2}, 1,
                        new int[]{1, 3, 2})
        );
    }

    private record TestCase(String name, int[] nums, int k, int[] expected) {
    }

}
