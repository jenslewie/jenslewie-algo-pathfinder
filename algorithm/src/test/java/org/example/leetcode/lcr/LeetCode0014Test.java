package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 014: String Permutation - Algorithm Variants")
class LeetCode0014Test {

    private static final LeetCode0014 LEET_CODE = new LeetCode0014();

    @FunctionalInterface
    interface CheckInclusionFunction {
        boolean apply(String s1, String s2);
    }

    private static final Map<String, CheckInclusionFunction> ALGO_VARIANTS = Map.of(
            "sliding_window_array", LEET_CODE::checkInclusion1,
            "sliding_window_map", LEET_CODE::checkInclusion2,
            "optimized_array", LEET_CODE::checkInclusion3,
            "two_pointers", LEET_CODE::checkInclusion4
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, s1=\"{2}\", s2=\"{3}\"")
    @MethodSource("allCombinations")
    void testCheckInclusion(String caseName, String algoName, String s1, String s2, boolean expected) {
        boolean actual = ALGO_VARIANTS.get(algoName).apply(s1, s2);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. s1=\"%s\", s2=\"%s\""
                .formatted(caseName, algoName, s1, s2));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.s1, tc.s2, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("found", "ab", "eidbaooo", true),
                new TestCase("not_found", "ab", "eidboaoo", false)
        );
    }

    private record TestCase(String name, String s1, String s2, boolean expected) {
    }
}
