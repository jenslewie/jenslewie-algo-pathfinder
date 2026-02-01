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

import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 206: Reverse Linked List - Algorithm Variants")
class LeetCode0206Test {

    private static final LeetCode0206_1 SOLUTION_1 = new LeetCode0206_1();
    private static final LeetCode0206_2 SOLUTION_2 = new LeetCode0206_2();

    @FunctionalInterface
    interface ReverseListFunction {
        ListNode apply(ListNode head);
    }

    private static final Map<String, ReverseListFunction> ALGO_VARIANTS = Map.of(
            "iterative", SOLUTION_1::reverseList,
            "sentinel_node", SOLUTION_2::reverseList
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, head={2}")
    @MethodSource("allCombinations")
    void testReverseList(String caseName, String algoName, Integer[] headArray, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = ALGO_VARIANTS.get(algoName).apply(head);

        if (expected == null) {
            assertNull(result, () -> "Case '%s' with algo='%s' failed. head=%s"
                    .formatted(caseName, algoName, Arrays.toString(headArray)));
        } else {
            LinkedListUtility.verify(expected, result, () -> "Case '%s' with algo='%s' failed. head=%s"
                    .formatted(caseName, algoName, Arrays.toString(headArray)));
        }
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.headArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new Integer[]{1, 2, 3, 4, 5},
                        new int[]{5, 4, 3, 2, 1}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new Integer[]{1, 2},
                        new int[]{2, 1}),

                // Example 3 from LeetCode: empty list
                new TestCase("example_3",
                        new Integer[]{},
                        null)
        );
    }

    private record TestCase(String name, Integer[] headArray, int[] expected) {
    }
}
