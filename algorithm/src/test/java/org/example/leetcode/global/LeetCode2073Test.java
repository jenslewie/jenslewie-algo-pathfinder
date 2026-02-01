package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 2073: Time Needed to Buy Tickets - Algorithm Variants")
class LeetCode2073Test {

    private static final LeetCode2073_1 SOLUTION_1 = new LeetCode2073_1();
    private static final LeetCode2073_2 SOLUTION_2 = new LeetCode2073_2();

    @FunctionalInterface
    interface TimeRequiredFunction {
        int apply(int[] tickets, int k);
    }

    private static final Map<String, TimeRequiredFunction> ALGO_VARIANTS = Map.of(
            "mathematical_calculation", SOLUTION_1::timeRequiredToBuy,
            "conditional_checks", SOLUTION_2::timeRequiredToBuy
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tickets={2}, k={3}")
    @MethodSource("allCombinations")
    void testTimeRequiredToBuy(String caseName, String algoName, int[] tickets, int k, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(tickets, k);

        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. tickets=%s, k=%d"
                .formatted(caseName, algoName, java.util.Arrays.toString(tickets), k));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.tickets, tc.k, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new int[]{2, 3, 2}, 2, 6),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[]{5, 1, 1, 1}, 0, 8),

                // Single person
                new TestCase("single_person",
                        new int[]{10}, 0, 10),

                // k = 0 (first person)
                new TestCase("k_equals_0",
                        new int[]{3, 2, 1}, 0, 6),

                // k = last index
                new TestCase("k_last_index",
                        new int[]{1, 2, 3}, 2, 6),

                // All same values
                new TestCase("all_same",
                        new int[]{4, 4, 4, 4}, 2, 15),

                // k in middle, mixed values
                new TestCase("k_middle",
                        new int[]{1, 5, 3, 2}, 2, 9),

                // Large values
                new TestCase("large_values",
                        new int[]{1000000000}, 0, 1000000000),

                // Zero tickets (edge, though problem guarantees >=1)
                new TestCase("zero_tickets",
                        new int[]{0, 1, 0}, 1, 1)
        );
    }

    private record TestCase(String name, int[] tickets, int k, int expected) {
    }

}
