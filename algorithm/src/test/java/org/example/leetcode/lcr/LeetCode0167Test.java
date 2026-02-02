package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 167: Dismantling Action (Longest Substring)")
class LeetCode0167Test {

    private static final LeetCode0167 SOLUTION = new LeetCode0167();

    @ParameterizedTest(name = "[{index}] case={0}, s=\"{1}\"")
    @MethodSource("testCases")
    void testDismantlingAction(String caseName, String s, int expected) {
        int actual = SOLUTION.dismantlingAction(s);
        assertEquals(expected, actual, () -> "Case '%s' failed. s=\"%s\""
                .formatted(caseName, s));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", "dbascDdad", 6),
                Arguments.of("all_same", "KKK", 1),
                Arguments.of("example_3", "pwwkew", 3)
        );
    }
}
