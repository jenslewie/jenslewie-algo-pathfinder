package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 853: Car Fleet - Algorithm Variants")
class LeetCode0853Test {

    @FunctionalInterface
    interface CarFleetFunction {
        int apply(int target, int[] position, int[] speed);
    }

    private static final Map<String, CarFleetFunction> ALGO_VARIANTS = Map.of(
            "monotonic_stack", (target, pos, spd) -> new LeetCode0853_1().carFleet(target, pos.clone(), spd.clone()),
            "greedy_from_front", (target, pos, spd) -> new LeetCode0853_2().carFleet(target, pos.clone(), spd.clone()),
            "bucket_sort_like", (target, pos, spd) -> new LeetCode0853_3().carFleet(target, pos.clone(), spd.clone())
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, target={2}, pos={3}, speed={4}")
    @MethodSource("allCombinations")
    void testCarFleet(String caseName, String algoName, int target, int[] position, int[] speed, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(target, position, speed);

        assertEquals(expected, actual, () -> String.format(
                "Case '%s' with algo='%s' failed. target=%d, position=%s, speed=%s",
                caseName, algoName, target,
                Arrays.toString(position),
                Arrays.toString(speed)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.target, tc.position, tc.speed, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode 853
                new TestCase("example_1", 12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}, 3),

                // Example 2 from LeetCode 853
                new TestCase("example_2", 10, new int[]{3}, new int[]{3}, 1),

                // Example 3 from LeetCode 853
                new TestCase("example_3", 100, new int[]{0, 2, 4}, new int[]{4, 2, 1}, 1),

                // All form one fleet
                new TestCase("one_fleet", 10, new int[]{9, 8, 7}, new int[]{1, 2, 3}, 1),

                // No fleet merge (all arrive at different times)
                new TestCase("no_merge", 10, new int[]{0, 1, 2}, new int[]{1, 1, 1}, 3),

                // Two cars, faster behind slower → merge
                new TestCase("two_cars_merge", 10, new int[]{5, 0}, new int[]{1, 2}, 1),

                // Two cars, faster ahead → no merge
                new TestCase("two_cars_no_merge", 10, new int[]{5, 0}, new int[]{2, 1}, 2),

                // Large target, sparse positions
                new TestCase("sparse_positions", 10000, new int[]{100, 500, 9999}, new int[]{10, 50, 1}, 3)
        );
    }

    private record TestCase(String name, int target, int[] position, int[] speed, int expected) {
    }

}
