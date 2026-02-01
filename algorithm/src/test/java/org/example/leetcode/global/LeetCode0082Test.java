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

@DisplayName("LeetCode 82: Remove Duplicates from Sorted List II - Algorithm Variants")
class LeetCode0082Test {

    private static final LeetCode0082 LEET_CODE = new LeetCode0082();

    @FunctionalInterface
    interface DeleteDuplicatesFunction {
        ListNode apply(ListNode head);
    }

    private static final Map<String, DeleteDuplicatesFunction> ALGO_VARIANTS = Map.of(
            "two_pointers_dual_list", LEET_CODE::deleteDuplicates,
            "single_pass_sentinel", LEET_CODE::deleteDuplicates2
    );

    @ParameterizedTest(name = "[{index}] case={0}, algo={1}, head={2}")
    @MethodSource("allCombinations")
    void testDeleteDuplicates(String caseName, String algoName, Integer[] headArray, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = ALGO_VARIANTS.get(algoName).apply(head);

        if (expected == null) {
            assertNull(result, () -> "Case '%s' with algo='%s' failed. head=%s"
                    .formatted(caseName, algoName, headArray == null ? "null" : Arrays.toString(headArray)));
        } else {
            LinkedListUtility.verify(expected, result, () -> "Case '%s' with algo='%s' failed. head=%s"
                    .formatted(caseName, algoName, headArray == null ? "null" : Arrays.toString(headArray)));
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
                        new Integer[]{1, 2, 3, 3, 4, 4, 5},
                        new int[]{1, 2, 5}),

                // Example 2 from LeetCode
                new TestCase("example_2",
                        new Integer[]{1, 1, 1, 2, 3},
                        new int[]{2, 3}),

                // Empty list
                new TestCase("empty_list",
                        new Integer[]{},
                        null),

                // Null list
                new TestCase("null_list",
                        null,
                        null)
        );
    }

    private record TestCase(String name, Integer[] headArray, int[] expected) {
    }
}
