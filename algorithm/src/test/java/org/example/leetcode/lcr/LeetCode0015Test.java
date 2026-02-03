package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 015: Find All Anagrams in a String")
class LeetCode0015Test {

    private static final LeetCode0015 SOLUTION = new LeetCode0015();

    @ParameterizedTest(name = "[{index}] case={0}, s=\"{1}\", p=\"{2}\"")
    @MethodSource("testCases")
    void testFindAnagrams(String caseName, String s, String p, List<Integer> expected) {
        List<Integer> actual = SOLUTION.findAnagrams(s, p);
        assertEquals(expected, actual, () -> "Case '%s' failed. s=\"%s\", p=\"%s\""
                .formatted(caseName, s, p));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", "cbaebabacd", "abc", List.of(0, 6)),
                Arguments.of("example_2", "abab", "ab", List.of(0, 1, 2)),
                Arguments.of("s_shorter_than_p", "ab", "abc", List.of()),
                Arguments.of("first_window_not_match", "baa", "aa", List.of(1))
        );
    }
}
