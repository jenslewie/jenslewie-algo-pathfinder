package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 567: Permutation in String")
class LeetCode0567Test {

    private static final LeetCode0567 LEET_CODE = new LeetCode0567();

    @ParameterizedTest(name = "[{index}] case={0}, s1=\"{1}\", s2=\"{2}\"")
    @MethodSource("testCases")
    void testCheckInclusion(String caseName, String s1, String s2, boolean expected) {
        boolean actual = LEET_CODE.checkInclusion(s1, s2);
        assertEquals(expected, actual, () -> "Case '%s' failed. s1=\"%s\", s2=\"%s\""
                .formatted(caseName, s1, s2));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", "ab", "eidbaooo", true),
                Arguments.of("example_2", "ab", "eidboaoo", false),
                Arguments.of("permutation_found", "abcdxioe", "abcdioxe", true)
        );
    }
}
