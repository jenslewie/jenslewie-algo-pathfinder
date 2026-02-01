package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 67: Add Binary")
class LeetCode0067Test {

    private static final LeetCode0067 LEET_CODE = new LeetCode0067();

    @ParameterizedTest(name = "[{index}] case={0}, a=\"{1}\", b=\"{2}\"")
    @MethodSource("testCases")
    void testAddBinary(String caseName, String a, String b, String expected) {
        String actual = LEET_CODE.addBinary(a, b);
        assertEquals(expected, actual, () -> "Case '%s' failed. a=\"%s\", b=\"%s\""
                .formatted(caseName, a, b));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", "11", "1", "100"),
                Arguments.of("example_2", "1010", "1011", "10101")
        );
    }
}
