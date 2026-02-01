package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 125: Valid Palindrome - Algorithm Variants")
public class LeetCode0125Test {

    private static final LeetCode0125_1 SOLUTION_1 = new LeetCode0125_1();
    private static final LeetCode0125_2 SOLUTION_2 = new LeetCode0125_2();
    private static final LeetCode0125_3 SOLUTION_3 = new LeetCode0125_3();

    @FunctionalInterface
    interface IsPalindromeFunction {
        boolean apply(String s);
    }

    private static final Map<String, IsPalindromeFunction> ALGO_VARIANTS = Map.of(
            "two_pointers_optimized", SOLUTION_1::isPalindrome,
            "two_pointers_basic", SOLUTION_2::isPalindrome,
            "preprocess_and_compare", SOLUTION_3::isPalindrome
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, input=\"{2}\"")
    @MethodSource("allCombinations")
    void testIsPalindrome(String caseName, String algoName, String input, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(input);

        if (expected) {
            assertTrue(actual, () -> "Case '%s' with algo='%s' failed. Input=\"%s\" should be a palindrome."
                    .formatted(caseName, algoName, input));
        } else {
            assertFalse(actual, () -> "Case '%s' with algo='%s' failed. Input=\"%s\" should not be a palindrome."
                    .formatted(caseName, algoName, input));
        }
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1", "A man, a plan, a canal: Panama", true),

                // Example 2 from LeetCode
                new TestCase("example_2", "race a car", false),

                // Example 3 from LeetCode
                new TestCase("example_3", " ", true),

                // Empty string
                new TestCase("empty_string", "", true),

                // Single character
                new TestCase("single_char", "a", true),

                // Mixed case palindrome
                new TestCase("mixed_case", "Aa", true),

                // Non-alphanumeric characters
                new TestCase("non_alphanum", "Madam, I'm Adam", true),

                // Numbers and letters
                new TestCase("alphanumeric", "A1B2b1a", true),

                // Not a palindrome
                new TestCase("not_palindrome", "hello", false),

                // Case insensitive check
                new TestCase("case_insensitive", "RaceACar", false)
        );
    }

    private record TestCase(String name, String input, boolean expected) {
    }
}
