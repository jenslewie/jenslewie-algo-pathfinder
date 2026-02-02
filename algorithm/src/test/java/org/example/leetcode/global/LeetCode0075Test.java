package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 75: Sort Colors - Algorithm Variants Test")
public class LeetCode0075Test {

    private static final LeetCode0075_1 SOLUTION_1 = new LeetCode0075_1();
    private static final LeetCode0075_2 SOLUTION_2 = new LeetCode0075_2();
    private static final LeetCode0075_3 SOLUTION_3 = new LeetCode0075_3();
    private static final LeetCode0075_4 SOLUTION_4 = new LeetCode0075_4();

    private static final Map<String, Consumer<int[]>> ALGO_VARIANTS = Map.of(
            "sortColors", SOLUTION_1::sortColors,
            "sortColors2", SOLUTION_2::sortColors,
            "sortColors3", SOLUTION_3::sortColors,
            "sortColors4", SOLUTION_4::sortColors
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, nums={2}")
    @MethodSource("allCombinations")
    void testSortColors(String caseName, String algoName, int[] input, int[] expected) {
        int[] actual = input.clone();
        ALGO_VARIANTS.get(algoName).accept(actual);
        assertArrayEquals(expected, actual, () -> "Case '%s' with algo '%s' failed on input %s"
                .formatted(caseName, algoName, Arrays.toString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("mixed", new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                new TestCase("short", new int[]{2, 0, 1}, new int[]{0, 1, 2}),
                new TestCase("no_zero", new int[]{2, 1, 2}, new int[]{1, 2, 2}),
                new TestCase("empty", new int[]{}, new int[]{}),
                new TestCase("single", new int[]{1}, new int[]{1}),
                new TestCase("all_ones", new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                new TestCase("sorted", new int[]{0, 1, 2}, new int[]{0, 1, 2}),
                new TestCase("reverse", new int[]{2, 2, 1, 1, 0, 0}, new int[]{0, 0, 1, 1, 2, 2})
        );
    }

    private record TestCase(String name, int[] input, int[] expected) {
    }

}
