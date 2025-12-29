package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.example.leetcode.utility.ArrayUtility.matrixToString;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 1109: Corporate Flight Bookings - Algorithm Variants")
class LeetCode1109Test {

    private static final LeetCode1109 LEET_CODE = new LeetCode1109();

    @FunctionalInterface
    interface FlightBookingsFunction {
        int[] apply(int[][] bookings, int n);
    }

    private static final Map<String, FlightBookingsFunction> ALGO_VARIANTS = Map.of(
            "diff_inplace", LEET_CODE::corpFlightBookings,
            "diff_separate", LEET_CODE::corpFlightBookings2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, books={2}, n={3}")
    @MethodSource("allCombinations")
    void testCorpFlightBookings(String caseName, String algoName, int[][] bookings, int n, int[] expected) {
        int[] actual = ALGO_VARIANTS.get(algoName).apply(bookings, n);

        assertArrayEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. bookings=%s, n=%d"
                .formatted(caseName, algoName, matrixToString(bookings), n));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.bookings, tc.n, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5,
                        new int[]{10, 55, 45, 25, 25}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new int[][]{{1, 2, 10}, {2, 2, 15}}, 2,
                        new int[]{10, 25}),

                // Single booking
                new TestCase("single_booking",
                        new int[][]{{1, 1, 5}}, 1,
                        new int[]{5}),

                // Booking covers all flights
                new TestCase("full_range",
                        new int[][]{{1, 5, 100}}, 5,
                        new int[]{100, 100, 100, 100, 100}),

                // Overlapping bookings
                new TestCase("overlap_at_start",
                        new int[][]{
                                {1, 3, 20},
                                {2, 4, 30},
                                {3, 5, 40}
                        }, 5,
                        new int[]{20, 50, 90, 70, 40}),

                // Booking ends at last flight (no subtraction needed)
                new TestCase("ends_at_n",
                        new int[][]{{1, 3, 10}, {3, 5, 20}}, 5,
                        new int[]{10, 10, 30, 20, 20}),

                // Multiple bookings on same segment
                new TestCase("same_segment",
                        new int[][]{
                                {2, 4, 5},
                                {2, 4, 10},
                                {2, 4, 15}
                        }, 5,
                        new int[]{0, 30, 30, 30, 0}),

                // n = 1, multiple bookings
                new TestCase("n_equals_1",
                        new int[][]{{1, 1, 100}, {1, 1, 200}}, 1,
                        new int[]{300}),

                // Empty bookings
                new TestCase("no_bookings",
                        new int[][]{}, 3,
                        new int[]{0, 0, 0})
        );
    }

    private record TestCase(String name, int[][] bookings, int n, int[] expected) {
    }

}