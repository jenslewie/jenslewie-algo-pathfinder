package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.example.leetcode.utility.ArrayUtility.matrixToString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1094: Car Pooling - Algorithm Variants")
class LeetCode1094Test {

    private static final LeetCode1094_1 SOLUTION_1 = new LeetCode1094_1();
    private static final LeetCode1094_2 SOLUTION_2 = new LeetCode1094_2();
    private static final LeetCode1094_3 SOLUTION_3 = new LeetCode1094_3();

    @FunctionalInterface
    interface CarPoolingFunction {
        boolean apply(int[][] trips, int capacity);
    }

    private static final Map<String, CarPoolingFunction> ALGO_VARIANTS = Map.of(
            "diff_array", SOLUTION_1::carPooling,
            "diff_array_with_util", SOLUTION_2::carPooling,
            "brute_force_map", SOLUTION_3::carPooling
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, trips={2}, capacity={3}")
    @MethodSource("allCombinations")
    void testCarPooling(String caseName, String algoName, int[][] trips, int capacity, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(trips, capacity);

        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. trips=%s, capacity=%d"
                .formatted(caseName, algoName, matrixToString(trips), capacity));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.trips, tc.capacity, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("example_1",
                        new int[][]{{2, 1, 5}, {3, 3, 7}}, 4, false),

                new TestCase("example_2",
                        new int[][]{{2, 1, 5}, {3, 3, 7}}, 5, true),

                new TestCase("example_3",
                        new int[][]{{2, 1, 5}, {3, 5, 7}}, 4, true),

                new TestCase("single_trip_ok",
                        new int[][]{{3, 0, 6}}, 3, true),

                new TestCase("single_trip_over",
                        new int[][]{{5, 2, 8}}, 4, false),

                new TestCase("no_trips",
                        new int[][]{}, 10, true),

                new TestCase("boundary_no_overlap",
                        new int[][]{{2, 1, 3}, {3, 3, 5}}, 5, true),

                new TestCase("heavy_overlap",
                        new int[][]{
                                {3, 0, 4},
                                {4, 2, 6},
                                {2, 3, 5}
                        }, 8, false),

                new TestCase("exact_capacity",
                        new int[][]{{2, 0, 5}, {3, 2, 7}}, 5, true),

                new TestCase("max_position_1000",
                        new int[][]{{100, 500, 1000}}, 100, true)
        );
    }

    private record TestCase(String name, int[][] trips, int capacity, boolean expected) {
    }

}