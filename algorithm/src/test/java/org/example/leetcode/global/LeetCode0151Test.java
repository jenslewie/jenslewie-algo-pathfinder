package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 151: Reverse Words in a String - Algorithm Variants")
class LeetCode0151Test {

    private static final LeetCode0151_1 SOLUTION_1 = new LeetCode0151_1();
    private static final LeetCode0151_2 SOLUTION_2 = new LeetCode0151_2();

    @FunctionalInterface
    interface ReverseWordsFunction {
        String apply(String s);
    }

    private static final Map<String, ReverseWordsFunction> ALGO_VARIANTS = Map.of(
            "split_reverse", SOLUTION_1::reverseWords,
            "two_pointers", SOLUTION_2::reverseWords
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, s=\"{2}\"")
    @MethodSource("allCombinations")
    void testReverseWords(String caseName, String algoName, String s, String expected) {
        String actual = ALGO_VARIANTS.get(algoName).apply(s);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. s=\"%s\""
                .formatted(caseName, algoName, s));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.s, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        "the sky is blue",
                        "blue is sky the"),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        "  hello world  ",
                        "world hello"),

                // Example 3 from LeetCode
                new TestCase("example_3",
                        "a good   example",
                        "example good a")
        );
    }

    private record TestCase(String name, String s, String expected) {
    }
}
