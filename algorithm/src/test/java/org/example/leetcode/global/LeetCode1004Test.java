package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1004: Max Consecutive Ones III - Algorithm Variants")
class LeetCode1004Test {

    private static final LeetCode1004_1 SOLUTION_1 = new LeetCode1004_1();
    private static final LeetCode1004_2 SOLUTION_2 = new LeetCode1004_2();

    @FunctionalInterface
    interface LongestOnesFunction {
        int apply(int[] nums, int k);
    }

    private static final Map<String, LongestOnesFunction> ALGO_VARIANTS = Map.of(
            "deque_approach", SOLUTION_1::longestOnes,
            "sliding_window_approach", SOLUTION_2::longestOnes
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, k={3}")
    @MethodSource("allCombinations")
    void testLongestOnes(String caseName, String algoName, int[] nums, int k, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(nums, k);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums=%s, k=%d"
                .formatted(caseName, algoName, Arrays.toString(nums), k));
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
                        new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                        2,
                        6),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                        3,
                        10),

                // Example 3: all zeros with enough k
                new TestCase("example_3",
                        new int[]{0, 0, 0, 1},
                        4,
                        4)
        );
    }

    private record TestCase(String name, int[] nums, int k, int expected) {
    }
}
