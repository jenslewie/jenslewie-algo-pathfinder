package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 76: Minimum Window Substring")
class LeetCode0076Test {

    private static final LeetCode0076 LEET_CODE = new LeetCode0076();

    @ParameterizedTest(name = "[{index}] case={0}, s=\"{1}\", t=\"{2}\"")
    @MethodSource("testCases")
    void testMinWindow(String caseName, String s, String t, String expected) {
        String actual = LEET_CODE.minWindow(s, t);
        assertEquals(expected, actual, () -> "Case '%s' failed. s=\"%s\", t=\"%s\""
                .formatted(caseName, s, t));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", "ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("example_2", "a", "a", "a"),
                Arguments.of("not_found", "a", "aa", "")
        );
    }
}
