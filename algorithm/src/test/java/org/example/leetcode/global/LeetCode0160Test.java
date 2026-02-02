package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.Pair;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 160: Intersection of Two Linked Lists - Algorithm Variants")
class LeetCode0160Test {

    private static final LeetCode0160_1 SOLUTION_1 = new LeetCode0160_1();
    private static final LeetCode0160_2 SOLUTION_2 = new LeetCode0160_2();

    @FunctionalInterface
    interface GetIntersectionFunction {
        ListNode apply(ListNode headA, ListNode headB);
    }

    private static final Map<String, GetIntersectionFunction> ALGO_VARIANTS = Map.of(
            "length_difference", SOLUTION_1::getIntersectionNode,
            "two_pointers", SOLUTION_2::getIntersectionNode
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testGetIntersectionNode(String caseName, String algoName, Integer[] listA, Integer[] listB, Integer[] intersection, int[] expected) {
        Pair<ListNode, ListNode> pair = LinkedListBuilder.buildIntersectionNode(listA, listB, intersection);
        ListNode result = ALGO_VARIANTS.get(algoName).apply(pair.first(), pair.second());

        if (expected == null) {
            assertNull(result, () -> "Case '%s' with algo='%s' failed. listA=%s, listB=%s, intersection=%s"
                    .formatted(caseName, algoName, Arrays.toString(listA), Arrays.toString(listB),
                            intersection == null ? "null" : Arrays.toString(intersection)));
        } else {
            LinkedListUtility.verify(expected, result, () -> "Case '%s' with algo='%s' failed. listA=%s, listB=%s, intersection=%s"
                    .formatted(caseName, algoName, Arrays.toString(listA), Arrays.toString(listB),
                            intersection == null ? "null" : Arrays.toString(intersection)));
        }
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.listA, tc.listB, tc.intersection, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new Integer[]{4},
                        new Integer[]{5, 6},
                        new Integer[]{1, 8, 4, 5},
                        new int[]{1, 8, 4, 5}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new Integer[]{1, 9, 1},
                        new Integer[]{3},
                        new Integer[]{2, 4},
                        new int[]{2, 4}),

                // Example 3 from LeetCode: no intersection
                new TestCase("example_3",
                        new Integer[]{2, 6, 4},
                        new Integer[]{1, 5},
                        null,
                        null)
        );
    }

    private record TestCase(String name, Integer[] listA, Integer[] listB, Integer[] intersection, int[] expected) {
    }
}
