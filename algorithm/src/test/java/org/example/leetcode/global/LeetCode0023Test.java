package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 23: Merge k Sorted Lists - Algorithm Variants")
class LeetCode0023Test {

    private static final LeetCode0023_1 SOLUTION_1 = new LeetCode0023_1();
    private static final LeetCode0023_2 SOLUTION_2 = new LeetCode0023_2();

    @FunctionalInterface
    interface MergeKListsFunction {
        ListNode apply(ListNode[] lists);
    }

    private static final Map<String, MergeKListsFunction> ALGO_VARIANTS = Map.of(
            "priority_queue", SOLUTION_1::mergeKLists,
            "divide_and_conquer", SOLUTION_2::mergeKLists
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}")
    @MethodSource("allCombinations")
    void testMergeKLists(String caseName, String algoName, Integer[][] listsArray, int[] expected) {
        ListNode[] lists = new ListNode[listsArray.length];
        for (int i = 0; i < listsArray.length; i++) {
            lists[i] = LinkedListBuilder.build(listsArray[i]);
        }

        ListNode result = ALGO_VARIANTS.get(algoName).apply(lists);

        if (expected == null) {
            assertNull(result, () -> "Case '%s' with algo='%s' failed. listsArray has %d lists"
                    .formatted(caseName, algoName, listsArray.length));
        } else {
            LinkedListUtility.verify(expected, result, () -> "Case '%s' with algo='%s' failed. listsArray has %d lists"
                    .formatted(caseName, algoName, listsArray.length));
        }
    }

    @Test
    void testMergeDivideAndConquerInvalidRange() {
        ListNode result = SOLUTION_2.merge(new ListNode[0], 1, 0);
        assertNull(result, "Expected null when l > r");
    }

    @Test
    void testMergeTwoListsWithNullList() {
        ListNode list = LinkedListBuilder.build(new Integer[]{1, 2, 4});
        ListNode result = SOLUTION_2.mergeTwoLists(null, list);
        LinkedListUtility.verify(new int[]{1, 2, 4}, result, () -> "Expected the non-null list to be returned");
    }

    @Test
    void testMergeTwoListsWithSecondNullList() {
        ListNode list = LinkedListBuilder.build(new Integer[]{2, 3});
        ListNode result = SOLUTION_2.mergeTwoLists(list, null);
        LinkedListUtility.verify(new int[]{2, 3}, result, () -> "Expected the non-null list to be returned");
    }

    private static Stream<Arguments> allCombinations() {
        return testCases().flatMap(tc -> ALGO_VARIANTS.keySet().stream()
                .map(algo -> Arguments.of(tc.name, algo, tc.listsArray, tc.expected))
        );
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                new TestCase("example_1",
                        new Integer[][]{
                                {1, 4, 5},
                                {1, 3, 4},
                                {2, 6}
                        },
                        new int[]{1, 1, 2, 3, 4, 4, 5, 6}),

                // Example 2 from LeetCode: empty array
                new TestCase("example_2",
                        new Integer[][]{},
                        null),

                // Example 3: all lists empty
                new TestCase("example_3",
                        new Integer[][]{
                                {},
                                {}
                        },
                        null),

                // Complex case: many lists
                new TestCase("complex",
                        new Integer[][]{
                                {1, 4, 5},
                                {2, 3, 4},
                                {3, 6},
                                {4, 6, 7},
                                {5, 6, 9},
                                {6, 9},
                                {7, 10, 11},
                                {8, 9, 10},
                                {9, 16, 17, 18},
                                {10, 11, 15}
                        },
                        new int[]{1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 15, 16, 17, 18})
        );
    }

    private record TestCase(String name, Integer[][] listsArray, int[] expected) {
    }
}
