package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 1019: Next Greater Node In Linked List - Algorithm Variants")
class LeetCode1019Test {

    @FunctionalInterface
    interface NextLargerNodesFunction {
        int[] apply(ListNode head);
    }

    private static final Map<String, NextLargerNodesFunction> ALGO_VARIANTS = Map.of(
            "recursive_reverse", head -> new LeetCode1019_1().nextLargerNodes(head),
            "iterative_reverse", head -> new LeetCode1019_2().nextLargerNodes(head),
            "forward_with_value_index_stack", head -> new LeetCode1019_3().nextLargerNodes(head),
            "convert_to_list_then_process", head -> new LeetCode1019_4().nextLargerNodes(head)
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, input={2}")
    @MethodSource("allCombinations")
    void testNextLargerNodes(String caseName, String algoName, int[] inputValues, int[] expected) {
        ListNode head = LinkedListBuilder.fromArray(inputValues);
        int[] actual = ALGO_VARIANTS.get(algoName).apply(head);

        assertArrayEquals(expected, actual, () -> String.format(
                "Case '%s' with algo='%s' failed. Input: %s",
                caseName, algoName, java.util.Arrays.toString(inputValues)));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.inputValues, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase("example_1", new int[]{2, 1, 5}, new int[]{5, 5, 0}),
                new TestCase("example_2", new int[]{2, 7, 4, 3, 5}, new int[]{7, 0, 5, 5, 0}),
                new TestCase("single_node", new int[]{1}, new int[]{0}),
                new TestCase("decreasing", new int[]{5, 4, 3, 2, 1}, new int[]{0, 0, 0, 0, 0}),
                new TestCase("increasing", new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 4, 5, 0}),
                new TestCase("all_equal", new int[]{3, 3, 3}, new int[]{0, 0, 0}),
                new TestCase("complex", new int[]{1, 7, 5, 1, 9, 2, 5, 1}, new int[]{7, 9, 9, 9, 0, 5, 0, 0}),
                new TestCase("two_nodes_desc", new int[]{3, 1}, new int[]{0, 0}),
                new TestCase("two_nodes_asc", new int[]{1, 3}, new int[]{3, 0})
        );
    }

    private record TestCase(String name, int[] inputValues, int[] expected) {
    }

}
