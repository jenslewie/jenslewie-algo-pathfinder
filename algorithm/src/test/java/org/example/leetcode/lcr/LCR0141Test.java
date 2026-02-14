package org.example.leetcode.lcr;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LCR 141: 训练计划 III - Algorithm Variants")
class LCR0141Test {

    private static final LCR0141 SOLUTION_1 = new LCR0141();

    @FunctionalInterface
    interface TrainingPlanFunction {
        ListNode apply(ListNode head);
    }

    private static final Map<String, TrainingPlanFunction> ALGO_VARIANTS = Map.of(
            "iterative_inplace_reverse", SOLUTION_1::trainningPlan
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, input={2}")
    @MethodSource("allCombinations")
    void testCases(String caseName, String algoName, Integer[] input, int[] expected) {
        ListNode head = LinkedListBuilder.build(input);
        ListNode result = ALGO_VARIANTS.get(algoName).apply(head);
        int[] actual = LinkedListBuilder.toArray(result);
        assertArrayEquals(expected, actual, () -> "Case '%s' with algo='%s' failed. input=%s"
                .formatted(caseName, algoName, Arrays.toString(input)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.input, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // === LeetCode Official Examples ===
                new TestCase("example_1", new Integer[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                new TestCase("example_2", new Integer[]{1, 2}, new int[]{2, 1}),
                new TestCase("example_3", new Integer[]{}, new int[]{}),

                // === Additional Coverage ===
                new TestCase("single_node", new Integer[]{42}, new int[]{42}),
                new TestCase("negative_values", new Integer[]{-1, -2, -3}, new int[]{-3, -2, -1})
        );
    }

    private record TestCase(String name, Integer[] input, int[] expected) {
    }
}
