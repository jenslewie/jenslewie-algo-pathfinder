package org.example.leetcode.lcr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LCR 147: Min Stack - Algorithm Variants")
class LCR0147Test {

    private static final String ALGO_NAME = "int_array_stack";

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, ops={2}, values={3}")
    @MethodSource("allCombinations")
    void testMinStack(String caseName, String algoName, List<String> ops, List<Integer> vals, List<Integer> expected) {
        List<Integer> actual = simulate(ops, vals);
        assertEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. ops=%s, vals=%s"
                .formatted(caseName, algoName, ops, vals));
    }

    private static List<Integer> simulate(List<String> ops, List<Integer> vals) {
        LCR0147 stack = new LCR0147();
        List<Integer> result = new ArrayList<>();
        int valIndex = 0;

        for (String op : ops) {
            switch (op) {
                case "MinStack":
                    break;
                case "push":
                    stack.push(vals.get(valIndex++));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    result.add(stack.top());
                    break;
                case "getMin":
                    result.add(stack.getMin());
                    break;
            }
        }
        return result;
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().map(tc -> Arguments.of(tc.name, ALGO_NAME, tc.ops, tc.vals, tc.expected)
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example from LCR 147 / LeetCode 155
                new TestCase("example",
                        List.of("MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"),
                        List.of(-2, 0, -3),
                        List.of(-3, 0, -2)),

                // Single value operations
                new TestCase("single_value",
                        List.of("MinStack", "push", "getMin", "top", "pop"),
                        List.of(42),
                        List.of(42, 42)),

                // Repeating minimum
                new TestCase("repeating_min",
                        List.of("MinStack", "push", "push", "push", "getMin", "pop", "getMin", "pop", "getMin"),
                        List.of(3, 1, 1),
                        List.of(1, 1, 3)),

                // Increasing sequence
                new TestCase("increasing",
                        List.of("MinStack", "push", "push", "push", "getMin", "top"),
                        List.of(1, 2, 3),
                        List.of(1, 3)),

                // Decreasing sequence
                new TestCase("decreasing",
                        List.of("MinStack", "push", "push", "push", "getMin", "pop", "getMin"),
                        List.of(3, 2, 1),
                        List.of(1, 2)),

                // Negative values
                new TestCase("negative_values",
                        List.of("MinStack", "push", "push", "getMin", "push", "getMin"),
                        List.of(-1, -2, -3),
                        List.of(-2, -3)),

                // Empty after pop (re-push)
                new TestCase("re_push_after_empty",
                        List.of("MinStack", "push", "pop", "push", "getMin"),
                        List.of(100, 200),
                        List.of(200))
        );
    }

    private record TestCase(String name, List<String> ops, List<Integer> vals, List<Integer> expected) {
    }

}