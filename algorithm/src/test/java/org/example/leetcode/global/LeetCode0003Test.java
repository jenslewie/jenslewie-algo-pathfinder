package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 3: Longest Substring Without Repeating Characters - Algorithm Variants")
class LeetCode0003Test {

    private static final LeetCode0003 LEET_CODE = new LeetCode0003();

    @FunctionalInterface
    interface LengthOfLongestSubstringFunction {
        int apply(String s);
    }

    private static final Map<String, LengthOfLongestSubstringFunction> ALGO_VARIANTS = Map.of(
            "sliding_window_set", LEET_CODE::lengthOfLongestSubstring,
            "sliding_window_map", LEET_CODE::lengthOfLongestSubstring2,
            "optimized_map", LEET_CODE::lengthOfLongestSubstring3
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, s=\"{2}\"")
    @MethodSource("allCombinations")
    void testLengthOfLongestSubstring(String caseName, String algoName, String s, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(s);
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
                new TestCase("example_1", "abcabcbb", 3),
                new TestCase("example_2", "bbbbb", 1),
                new TestCase("example_3", "pwwkew", 3),
                new TestCase("single_space", " ", 1),
                new TestCase("custom_case", "dfdv", 3)
        );
    }

    private record TestCase(String name, String s, int expected) {
    }
}
