package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("LeetCode 2: Add Two Numbers")
class LeetCode0002Test {

    private static final LeetCode0002 LEET_CODE = new LeetCode0002();

    @ParameterizedTest(name = "[{index}] case={0}, l1={1}, l2={2}")
    @MethodSource("testCases")
    void testAddTwoNumbers(String caseName, Integer[] l1Array, Integer[] l2Array, int[] expected) {
        ListNode l1 = LinkedListBuilder.build(l1Array);
        ListNode l2 = LinkedListBuilder.build(l2Array);

        ListNode result = LEET_CODE.addTwoNumbers(l1, l2);

        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. l1=%s, l2=%s"
                .formatted(caseName, Arrays.toString(l1Array), Arrays.toString(l2Array)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{2, 4, 3},
                        new Integer[]{5, 6, 4},
                        new int[]{7, 0, 8}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{0},
                        new Integer[]{0},
                        new int[]{0}),

                // Example 3 from LeetCode
                Arguments.of("example_3",
                        new Integer[]{9, 9, 9, 9, 9, 9, 9},
                        new Integer[]{9, 9, 9, 9},
                        new int[]{8, 9, 9, 9, 0, 0, 0, 1})
        );
    }
}
