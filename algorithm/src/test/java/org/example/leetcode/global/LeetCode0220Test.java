package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 220: Contains Duplicate III - Algorithm Variants")
class LeetCode0220Test {

    private static final LeetCode0220 LEET_CODE = new LeetCode0220();

    @FunctionalInterface
    interface ContainsDuplicateFunction {
        boolean apply(int[] nums, int indexDiff, int valueDiff);
    }

    private static final Map<String, ContainsDuplicateFunction> ALGO_VARIANTS = Map.of(
            "sliding_window_treeset", LEET_CODE::containsNearbyAlmostDuplicate,
            "bucket_sort", LEET_CODE::containsNearbyAlmostDuplicate2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}, indexDiff={3}, valueDiff={4}")
    @MethodSource("allCombinations")
    void testContainsNearbyAlmostDuplicate(String caseName, String algoName, int[] nums, int indexDiff, int valueDiff, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(nums, indexDiff, valueDiff);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. nums=%s, indexDiff=%d, valueDiff=%d"
                .formatted(caseName, algoName, Arrays.toString(nums), indexDiff, valueDiff));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.nums, tc.indexDiff, tc.valueDiff, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new int[]{1, 2, 3, 1},
                        3,
                        0,
                        true),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{1, 5, 9, 1, 5, 9},
                        2,
                        3,
                        false)
        );
    }

    private record TestCase(String name, int[] nums, int indexDiff, int valueDiff, boolean expected) {
    }
}
