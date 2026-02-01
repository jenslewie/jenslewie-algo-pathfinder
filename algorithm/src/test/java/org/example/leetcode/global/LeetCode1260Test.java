package org.example.leetcode.global;

import org.example.leetcode.utility.ArrayUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1260: Shift 2D Grid - Algorithm Variants")
class LeetCode1260Test {

    private static final LeetCode1260_1 SOLUTION_1 = new LeetCode1260_1();
    private static final LeetCode1260_2 SOLUTION_2 = new LeetCode1260_2();
    private static final LeetCode1260_3 SOLUTION_3 = new LeetCode1260_3();
    private static final LeetCode1260_4 SOLUTION_4 = new LeetCode1260_4();

    @FunctionalInterface
    interface ShiftGridFunction {
        List<List<Integer>> apply(int[][] grid, int k);
    }

    private static final Map<String, ShiftGridFunction> ALGO_VARIANTS = Map.of(
            "direct_index_mapping", SOLUTION_1::shiftGrid,
            "reverse_array_approach", SOLUTION_2::shiftGrid,
            "array_flattening_approach", SOLUTION_3::shiftGrid,
            "direct_assignment_approach", SOLUTION_4::shiftGrid
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, grid={2}, k={3}")
    @MethodSource("allCombinations")
    void testShiftGrid(String caseName, String algoName, int[][] input, int k, List<List<Integer>> expected) {
        int[][] inputClone = ArrayUtility.deepClone(input);
        List<List<Integer>> actual = ALGO_VARIANTS.get(algoName).apply(inputClone, k);

        assertEquals(expected, actual, () -> "Case '%s' with algo '%s' failed for k=%d. Input grid: %s"
                .formatted(caseName, algoName, k, ArrayUtility.matrixToString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.k, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("example_1",
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        1,
                        Arrays.asList(
                                Arrays.asList(9, 1, 2),
                                Arrays.asList(3, 4, 5),
                                Arrays.asList(6, 7, 8)
                        )),

                new TestCase("example_2",
                        new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}},
                        4,
                        Arrays.asList(
                                Arrays.asList(12, 0, 21, 13),
                                Arrays.asList(3, 8, 1, 9),
                                Arrays.asList(19, 7, 2, 5),
                                Arrays.asList(4, 6, 11, 10)
                        )),

                new TestCase("single_cell",
                        new int[][]{{5}},
                        100,
                        List.of(List.of(5))),

                new TestCase("single_row",
                        new int[][]{{1, 2, 3, 4}},
                        2,
                        List.of(Arrays.asList(3, 4, 1, 2))),

                new TestCase("single_column",
                        new int[][]{{1}, {2}, {3}, {4}},
                        2,
                        Arrays.asList(
                                List.of(3),
                                List.of(4),
                                List.of(1),
                                List.of(2))),

                new TestCase("no_shift",
                        new int[][]{{1, 2}, {3, 4}},
                        0,
                        Arrays.asList(
                                Arrays.asList(1, 2),
                                Arrays.asList(3, 4))),

                new TestCase("full_cycle",
                        new int[][]{{1, 2}, {3, 4}},
                        4,
                        Arrays.asList(
                                Arrays.asList(1, 2),
                                Arrays.asList(3, 4))),

                new TestCase("k_larger_than_size",
                        new int[][]{{1, 2, 3}},
                        5, // 5 % 3 = 2
                        List.of(Arrays.asList(2, 3, 1))),

                new TestCase("2x2_normal",
                        new int[][]{{1, 2}, {3, 4}},
                        1,
                        Arrays.asList(
                                Arrays.asList(4, 1),
                                Arrays.asList(2, 3)))
        );
    }

    private record TestCase(String name, int[][] input, int k, List<List<Integer>> expected) {
    }

}