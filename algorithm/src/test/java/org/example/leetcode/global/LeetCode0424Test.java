package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 424: Longest Repeating Character Replacement")
class LeetCode0424Test {

    private static final LeetCode0424 SOLUTION = new LeetCode0424();

    @ParameterizedTest(name = "[{index}] case={0}, s=\"{1}\", k={2}")
    @MethodSource("testCases")
    void testCharacterReplacement(String caseName, String s, int k, int expected) {
        int actual = SOLUTION.characterReplacement(s, k);
        assertEquals(expected, actual, () -> "Case '%s' failed. s=\"%s\", k=%d"
                .formatted(caseName, s, k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        "ABAB",
                        2,
                        4),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        "AABABBA",
                        1,
                        4)
        );
    }
}
