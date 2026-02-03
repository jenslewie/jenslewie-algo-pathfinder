package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 14: Longest Common Prefix - Algorithm Variants")
class LeetCode0014Test {

    private static final LeetCode0014_1 SOLUTION_1 = new LeetCode0014_1();
    private static final LeetCode0014_2 SOLUTION_2 = new LeetCode0014_2();
    private static final LeetCode0014_3 SOLUTION_3 = new LeetCode0014_3();

    @FunctionalInterface
    interface LCPFunction {
        String apply(String[] strs);
    }

    private static final Map<String, LCPFunction> ALGO_VARIANTS = Map.of(
            "vertical_scanning", SOLUTION_1::longestCommonPrefix,
            "horizontal_scanning", SOLUTION_2::longestCommonPrefix,
            "character_map_scanning", SOLUTION_3::longestCommonPrefix
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, strs={2}")
    @MethodSource("allCombinations")
    void testLongestCommonPrefix(String caseName, String algoName, String[] input, String expected) {
        String actual = ALGO_VARIANTS.get(algoName).apply(input);

        assertEquals(expected, actual, () -> "Case '%s' with algo '%s' failed. Input: %s"
                .formatted(caseName, algoName, java.util.Arrays.toString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("common_prefix_flow",
                        new String[]{"flower", "flow", "flight"},
                        "fl"),

                // Example 2 from LeetCode
                new TestCase("no_common_prefix",
                        new String[]{"dog", "racecar", "car"},
                        ""),

                // Single string
                new TestCase("single_string",
                        new String[]{"hello"},
                        "hello"),

                // Empty array
                new TestCase("empty_array",
                        new String[]{},
                        ""),

                // All strings identical
                new TestCase("all_identical",
                        new String[]{"test", "test", "test"},
                        "test"),

                // Prefix is entire shortest string
                new TestCase("prefix_is_shortest",
                        new String[]{"ab", "abc", "abcd"},
                        "ab"),

                // One string is prefix of others
                new TestCase("one_is_prefix",
                        new String[]{"", "abc", "abd"},
                        ""),

                // Strings with same starting char but diverge immediately
                new TestCase("same_first_char",
                        new String[]{"aab", "aac", "aad"},
                        "aa"),

                // Very long common prefix
                new TestCase("long_prefix",
                        new String[]{
                                "abcdefghijklmnopqrstuvwxyz",
                                "abcdefghijklmnopqrstuvwxzz",
                                "abcdefghijklmnopqrstuvwxyy"
                        },
                        "abcdefghijklmnopqrstuvwx"),

                // Mixed case (though problem assumes lowercase, but test robustness)
                new TestCase("with_empty_string",
                        new String[]{"", "abc"},
                        ""),

                // First string longer than others
                new TestCase("first_longer",
                        new String[]{"abcd", "ab"},
                        "ab"),

                // Long strings to reach loop bound in variant 3
                new TestCase("long_200",
                        new String[]{"a".repeat(200), "a".repeat(200)},
                        "a".repeat(200))
        );
    }

    private record TestCase(String name, String[] input, String expected) {
    }
}
