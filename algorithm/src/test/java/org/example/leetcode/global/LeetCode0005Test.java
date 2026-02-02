package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 5: Longest Palindromic Substring")
class LeetCode0005Test {

    private static final LeetCode0005 SOLUTION = new LeetCode0005();

    @ParameterizedTest(name = "[{index}] case={0}, s=\"{1}\"")
    @MethodSource("testCases")
    void testLongestPalindrome(String caseName, String s, String expected) {
        String actual = SOLUTION.longestPalindrome(s);
        assertEquals(expected, actual, () -> "Case '%s' failed. s=\"%s\""
                .formatted(caseName, s));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", "babad", "aba"),
                Arguments.of("example_2", "cbbd", "bb"),
                Arguments.of("single_char", "a", "a")
        );
    }
}
