package org.example.leetcode.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 402: Remove K Digits - Algorithm Variants")
class LeetCode0402Test {

    @FunctionalInterface
    interface RemoveKDigitsFunction {
        String apply(String num, int k);
    }

    private static final Map<String, RemoveKDigitsFunction> ALGO_VARIANTS = Map.of(
            "stack_char_from_left", (num, k) -> new LeetCode0402_1().removeKdigits(num, k),
            "deque_char_from_left", (num, k) -> new LeetCode0402_2().removeKdigits(num, k),
            "array_index_stack", (num, k) -> new LeetCode0402_3().removeKdigits(num, k)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, num={2}, k={3}")
    @MethodSource("allCombinations")
    void testRemoveKDigits(String caseName, String algoName, String num, int k, String expected) {
        String actual = ALGO_VARIANTS.get(algoName).apply(num, k);

        assertEquals(expected, actual, () -> String.format(
                "Case '%s' with algo='%s' failed. Input: num='%s', k=%d",
                caseName, algoName, num, k));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.num, tc.k, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Official-like example
                new TestCase("example_1", "1432219", 3, "1219"),

                // Leading zeros after removal
                new TestCase("leading_zeros_1", "10200", 1, "200"),

                // Remove all digits
                new TestCase("remove_all", "10", 2, "0"),

                // Single digit, remove it
                new TestCase("single_digit", "9", 1, "0"),

                // Duplicate digits
                new TestCase("duplicate_digits", "112", 1, "11"),

                // Remove one from "10001" → remove first '1' → "0001" → "1"
                new TestCase("many_zeros_middle", "10001", 1, "1"),

                // "100", k=1 → remove '1' → "00" → "0"
                new TestCase("zeros_at_end", "100", 1, "0"),

                // Large input
                new TestCase("large_input", "33526221184202197273", 19, "0"),

                // No removal
                new TestCase("k_zero", "12345", 0, "12345")
        );
    }

    private record TestCase(String name, String num, int k, String expected) {
    }

}
