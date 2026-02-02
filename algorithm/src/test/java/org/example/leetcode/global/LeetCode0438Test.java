package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 438: Find All Anagrams in a String")
class LeetCode0438Test {

    private static final LeetCode0438 SOLUTION = new LeetCode0438();

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
                Arguments.of("example_2", "abab", "ab", List.of(0, 1, 2))
        );
    }
}
