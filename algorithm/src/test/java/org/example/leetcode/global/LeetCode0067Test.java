package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 67: Add Binary - Algorithm Variants")
class LeetCode0067Test {

    private static final LeetCode0067_1 SOLUTION_1 = new LeetCode0067_1();
    private static final LeetCode0067_2 SOLUTION_2 = new LeetCode0067_2();

    private static final Map<String, BiFunction<String, String, String>> ALGO_VARIANTS = Map.of(
            "direct_iteration", SOLUTION_1::addBinary,
            "stack_based", SOLUTION_2::addBinary
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, a={2}, b={3}")
    @MethodSource("allCombinations")
    void testAddBinary(String caseName, String algoName, String a, String b, String expected) {
        String actual = ALGO_VARIANTS.get(algoName).apply(a, b);
        assertEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. a='%s', b='%s'"
                .formatted(caseName, algoName, a, b));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.a, tc.b, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("example_1", "11", "1", "100"),
                new TestCase("example_2", "1010", "1011", "10101"),
                new TestCase("different_lengths", "1", "111", "1000"),
                new TestCase("no_carry", "0", "0", "0"),
                new TestCase("carry_chain", "1111", "1", "10000")
        );
    }

    private record TestCase(String name, String a, String b, String expected) {
    }
}
