package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 344: Reverse String")
class LeetCode0344Test {

    private static final LeetCode0344 LEET_CODE = new LeetCode0344();

    @ParameterizedTest(name = "[{index}] case={0}, s={1}")
    @MethodSource("testCases")
    void testReverseString(String caseName, char[] s, char[] expected) {
        char[] input = Arrays.copyOf(s, s.length);
        LEET_CODE.reverseString(s);
        assertArrayEquals(expected, s, () -> "Case '%s' failed. Input s: %s"
                .formatted(caseName, Arrays.toString(input)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
                Arguments.of("example_2", new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
        );
    }
}
