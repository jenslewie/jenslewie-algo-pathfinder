package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 036: Evaluate RPN - Algorithm Variants")
class LeetCode0036Test {

    private static final LeetCode0036 SOLUTION = new LeetCode0036();

    @FunctionalInterface
    interface EvalRPNFunction {
        int apply(String[] tokens);
    }

    private static final Map<String, EvalRPNFunction> ALGO_VARIANTS = Map.of(
            "array_stack", SOLUTION::evalRPN
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, tokens={2}")
    @MethodSource("allCombinations")
    void testEvalRPN(String caseName, String algoName, String[] tokens, int expected) {
        int actual = ALGO_VARIANTS.get(algoName).apply(tokens);

        assertEquals(expected, actual,
                String.format("Case '%s' with algo='%s' failed. tokens=%s",
                        caseName, algoName, Arrays.toString(tokens)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.tokens, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LCR 036 / LeetCode 150
                new TestCase("example_1", new String[]{"2", "1", "+", "3", "*"}, 9),

                // Example 2 from LCR 036 / LeetCode 150
                new TestCase("example_2", new String[]{"4", "13", "5", "/", "+"}, 6),

                // Example 3 from LCR 036 / LeetCode 150
                new TestCase("example_3",
                        new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22),

                // Single number
                new TestCase("single_number", new String[]{"42"}, 42),

                // Negative result
                new TestCase("negative_result", new String[]{"3", "4", "-"}, -1),

                // Division truncation towards zero
                new TestCase("division_truncation", new String[]{"13", "5", "/"}, 2),

                // Negative division (toward zero)
                new TestCase("negative_division", new String[]{"-13", "5", "/"}, -2),

                // Multiplication
                new TestCase("multiplication", new String[]{"5", "3", "*"}, 15),

                // Complex verified case
                new TestCase("complex_case", new String[]{"4", "-2", "/", "5", "*"}, -10),

                // Mixed operators (classic)
                new TestCase("mixed_ops", new String[]{"5", "1", "2", "+", "4", "*", "+", "3", "-"}, 14),

                // Simple addition
                new TestCase("simple_add", new String[]{"1", "2", "+"}, 3),

                // Simple subtraction
                new TestCase("simple_sub", new String[]{"5", "3", "-"}, 2),

                // Simple division
                new TestCase("simple_div", new String[]{"8", "4", "/"}, 2)
        );
    }

    private record TestCase(String name, String[] tokens, int expected) {
    }

}
