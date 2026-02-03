package org.example.leetcode.lcr;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("LCR 025: Add Two Numbers II")
class LeetCode0025Test {

    private static final LeetCode0025 SOLUTION = new LeetCode0025();

    @ParameterizedTest(name = "[{index}] case={0}, l1={1}, l2={2}")
    @MethodSource("testCases")
    void testAddTwoNumbers(String caseName, Integer[] l1Array, Integer[] l2Array, int[] expected) {
        ListNode l1 = LinkedListBuilder.build(l1Array);
        ListNode l2 = LinkedListBuilder.build(l2Array);

        ListNode result = SOLUTION.addTwoNumbers(l1, l2);

        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. l1=%s, l2=%s"
                .formatted(caseName, Arrays.toString(l1Array), Arrays.toString(l2Array)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("example_1", new Integer[]{2, 4, 3}, new Integer[]{5, 6, 4}, new int[]{8, 0, 7}),
                Arguments.of("both_zero", new Integer[]{0}, new Integer[]{0}, new int[]{0}),
                Arguments.of("different_length", new Integer[]{7, 2, 4, 3}, new Integer[]{5, 6, 4}, new int[]{7, 8, 0, 7}),
                Arguments.of("final_carry", new Integer[]{9, 9}, new Integer[]{1}, new int[]{1, 0, 0}),
                Arguments.of("first_shorter", new Integer[]{5, 6, 4}, new Integer[]{7, 2, 4, 3}, new int[]{7, 8, 0, 7})
        );
    }
}
