package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 1944: Number of Visible People in a Queue - Algorithm Variants")
class LeetCode1944Test {

    @FunctionalInterface
    interface CanSeePersonsCountFunction {
        int[] apply(int[] heights);
    }

    private static final Map<String, CanSeePersonsCountFunction> ALGO_VARIANTS = Map.of(
            "monotonic_stack_from_right", heights -> new LeetCode1944_1().canSeePersonsCount(heights),
            "monotonic_stack_from_left_with_index", heights -> new LeetCode1944_2().canSeePersonsCount(heights)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, heights={2}")
    @MethodSource("allCombinations")
    void testCanSeePersonsCount(String caseName, String algoName, int[] heights, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(heights);

        assertArrayEquals(expected, actual, () -> String.format("Case '%s' with algo='%s' failed. Input heights: %s",
                caseName, algoName, java.util.Arrays.toString(heights)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.heights, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode 1944
                new TestCase("example_1", new int[]{10, 6, 8, 5, 11, 9}, new int[]{3, 1, 2, 1, 1, 0}),

                // Strictly decreasing (distinct)
                new TestCase("strictly_decreasing", new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 1, 1, 0}),

                // Strictly increasing (distinct)
                new TestCase("strictly_increasing", new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 0}),

                // Single person
                new TestCase("single", new int[]{100}, new int[]{0}),

                // Two: short then tall
                new TestCase("two_asc", new int[]{3, 5}, new int[]{1, 0}),

                // Two: tall then short
                new TestCase("two_desc", new int[]{5, 3}, new int[]{1, 0}),

                // Complex case with distinct values
                new TestCase("complex", new int[]{8, 7, 9, 5, 4, 6, 10}, new int[]{2, 1, 3, 2, 1, 1, 0}),

                // Peak at beginning
                new TestCase("peak_first", new int[]{10, 1, 2, 3, 4}, new int[]{4, 1, 1, 1, 0}),

                // Valley in middle (all distinct)
                new TestCase("valley", new int[]{6, 2, 1, 3, 5}, new int[]{3, 2, 1, 1, 0})
        );
    }

    private record TestCase(String name, int[] heights, int[] expected) {
    }

}
