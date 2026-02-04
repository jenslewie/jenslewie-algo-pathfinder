package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 014: String Permutation - Algorithm Variants")
class LCR0014Test {

    private static final LCR0014_1 SOLUTION_1 = new LCR0014_1();
    private static final LCR0014_2 SOLUTION_2 = new LCR0014_2();
    private static final LCR0014_3 SOLUTION_3 = new LCR0014_3();
    private static final LCR0014_4 SOLUTION_4 = new LCR0014_4();

    @FunctionalInterface
    interface CheckInclusionFunction {
        boolean apply(String s1, String s2);
    }

    private static final Map<String, CheckInclusionFunction> ALGO_VARIANTS = Map.of(
            "count_array_approach", SOLUTION_1::checkInclusion,
            "fixed_arrays_comparison", SOLUTION_2::checkInclusion,
            "explicit_size_check", SOLUTION_3::checkInclusion,
            "hashmap_mapping", SOLUTION_4::checkInclusion
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
                new TestCase("not_found", "ab", "eidboaoo", false),
                new TestCase("s1_longer_than_s2", "abcd", "abc", false),
                new TestCase("equal_length_match", "ab", "ab", true),
                new TestCase("repeated_chars", "aab", "aaab", true)
        );
    }

    private record TestCase(String name, String s1, String s2, boolean expected) {
    }
}
