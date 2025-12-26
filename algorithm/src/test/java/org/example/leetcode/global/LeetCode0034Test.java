package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 34: Find First and Last Position - Algorithm Variants")
class LeetCode0034Test {

    private static final LeetCode0034 LEET_CODE = new LeetCode0034();

    @FunctionalInterface
    interface SearchRangeFunction {
        int[] apply(int[] nums, int target);
    }

    private static final Map<String, SearchRangeFunction> ALGO_VARIANTS = Map.of(
            "left_bound_twice", LEET_CODE::searchRange,
            "left_and_right_bound", LEET_CODE::searchRange2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, target={3}")
    @MethodSource("allCombinations")
    void testSearchRange(String caseName, String algoName, int[] nums, int target, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(nums, target);

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. nums=%s, target=%d"
                .formatted(caseName, algoName, java.util.Arrays.toString(nums), target));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.target, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("target_exists",
                        new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),

                // Example 2 from LeetCode
                new TestCase("target_not_exists",
                        new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),

                // Example 3 from LeetCode
                new TestCase("empty_array",
                        new int[]{}, 0, new int[]{-1, -1}),

                // Single element matches
                new TestCase("single_match",
                        new int[]{1}, 1, new int[]{0, 0}),

                // Single element not match
                new TestCase("single_mismatch",
                        new int[]{1}, 2, new int[]{-1, -1}),

                // All elements same and match
                new TestCase("all_same_match",
                        new int[]{2, 2, 2, 2}, 2, new int[]{0, 3}),

                // Target at beginning
                new TestCase("target_at_start",
                        new int[]{1, 2, 2, 3}, 1, new int[]{0, 0}),

                // Target at end
                new TestCase("target_at_end",
                        new int[]{1, 2, 2, 3}, 3, new int[]{3, 3}),

                // Duplicate at edges
                new TestCase("duplicates_edges",
                        new int[]{2, 2, 3, 3, 3, 4}, 3, new int[]{2, 4}),

                // Multiple non-target duplicates
                new TestCase("non_target_duplicates",
                        new int[]{1, 1, 2, 2, 3, 3}, 2, new int[]{2, 3}),

                // Large values
                new TestCase("large_values",
                        new int[]{-1_000_000_000, 0, 0, 1_000_000_000}, 0, new int[]{1, 2})
        );
    }

    private record TestCase(String name, int[] nums, int target, int[] expected) {
    }

}