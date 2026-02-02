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

@DisplayName("LeetCode 876: Middle of the Linked List")
class LeetCode0876Test {

    private static final LeetCode0876 SOLUTION = new LeetCode0876();

    @ParameterizedTest(name = "[{index}] case={0}, list={1}")
    @MethodSource("testCases")
    void testMiddleNode(String caseName, Integer[] listArray, int[] expected) {
        ListNode listNode = LinkedListBuilder.build(listArray);
        ListNode result = SOLUTION.middleNode(listNode);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. list=%s"
                .formatted(caseName, Arrays.toString(listArray)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{1, 2, 3, 4, 5},
                        new int[]{3, 4, 5}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{1, 2, 3, 4, 5, 6},
                        new int[]{4, 5, 6})
        );
    }
}
