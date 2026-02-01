package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 219: Contains Duplicate II - Algorithm Variants")
class LeetCode0219Test {

    private static final LeetCode0219_1 SOLUTION_1 = new LeetCode0219_1();
    private static final LeetCode0219_2 SOLUTION_2 = new LeetCode0219_2();
    private static final LeetCode0219_3 SOLUTION_3 = new LeetCode0219_3();

    @FunctionalInterface
    interface ContainsDuplicateFunction {
        boolean apply(int[] nums, int k);
    }

    private static final Map<String, ContainsDuplicateFunction> ALGO_VARIANTS = Map.of(
            "hash_map", SOLUTION_1::containsNearbyDuplicate,
            "sliding_window_set", SOLUTION_2::containsNearbyDuplicate,
            "brute_force", SOLUTION_3::containsNearbyDuplicate
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, k={3}")
    @MethodSource("allCombinations")
    void testContainsNearbyDuplicate(String caseName, String algoName, int[] nums, int k, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(nums, k);
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
                        new int[]{1, 2, 3, 1},
                        3,
                        true),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{1, 0, 1, 1},
                        1,
                        true),

                // Example 3 from LeetCode
                new TestCase("example_3",
                        new int[]{1, 2, 3, 1, 2, 3},
                        2,
                        false)
        );
    }

    private record TestCase(String name, int[] nums, int k, boolean expected) {
    }
}
