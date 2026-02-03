package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

@DisplayName("LeetCode 61: Rotate List - Algorithm Variants")
class LeetCode0061Test {

    private static final LeetCode0061_1 SOLUTION_1 = new LeetCode0061_1();
    private static final LeetCode0061_2 SOLUTION_2 = new LeetCode0061_2();
    private static final LeetCode0061_3 SOLUTION_3 = new LeetCode0061_3();

    @FunctionalInterface
    interface RotateRightFunction {
        ListNode apply(ListNode head, int k);
    }

    private static final Map<String, RotateRightFunction> ALGO_VARIANTS = Map.of(
            "calculate_position", SOLUTION_1::rotateRight,
            "move_nodes_to_front", SOLUTION_2::rotateRight,
            "reverse_parts", SOLUTION_3::rotateRight
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, head={2}, k={3}")
    @MethodSource("allCombinations")
    void testRotateRight(String caseName, String algoName, Integer[] headArray, int k, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = ALGO_VARIANTS.get(algoName).apply(head, k);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' with algo='%s' failed. head=%s, k=%d"
                .formatted(caseName, algoName, Arrays.toString(headArray), k));
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.headArray, tc.k, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new Integer[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{4, 5, 1, 2, 3}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new Integer[]{1, 2},
                        0,
                        new int[]{1, 2}),

                // k multiple of length
                new TestCase("k_multiple_of_len",
                        new Integer[]{1, 2, 3},
                        3,
                        new int[]{1, 2, 3}),

                // k greater than length
                new TestCase("k_greater_than_len",
                        new Integer[]{1, 2, 3},
                        5,
                        new int[]{2, 3, 1}),

                // Single node
                new TestCase("single_node",
                        new Integer[]{1},
                        4,
                        new int[]{1}),

                // Empty list
                new TestCase("empty_list",
                        new Integer[]{},
                        2,
                        new int[]{})
        );
    }

    private record TestCase(String name, Integer[] headArray, int k, int[] expected) {
    }
}
