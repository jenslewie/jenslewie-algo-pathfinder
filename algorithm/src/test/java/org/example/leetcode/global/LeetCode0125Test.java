package org.example.leetcode.global;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeetCode0125Test {

    private static final LeetCode0125 SOLUTION = new LeetCode0125();
    private static final Map<String, Function<String, Boolean>> ALGO_VARIANTS = Map.of(
            "isPalindrome", SOLUTION::isPalindrome,
            "isPalindrome2", SOLUTION::isPalindrome2,
            "isPalindrome3", SOLUTION::isPalindrome3
    );

    @ParameterizedTest(name = "[{index}] {0} | Input: {1}")
    @MethodSource("testCases")
    void test(String caseName, String input, boolean expectedResult) {
        ALGO_VARIANTS.forEach((algoName, algo) -> {
            if (expectedResult) {
                assertTrue(algo.apply(input), () -> "[%s|%s] it is expected as a palindrome.".formatted(algoName, caseName));
            } else {
                assertFalse(algo.apply(input), () -> "[%s|%s] it is not expected as a palindrome.".formatted(algoName, caseName));
            }
        });
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("test1", "A man, a plan, a canal: Panama", true),
                Arguments.of("test2", "race a car", false),
                Arguments.of("test3", " ", true)
        );
    }

}
