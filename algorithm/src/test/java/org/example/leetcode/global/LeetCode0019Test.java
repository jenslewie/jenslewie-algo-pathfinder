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

import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("LeetCode 19: Remove Nth Node From End of List")
class LeetCode0019Test {

    private static final LeetCode0019 LEET_CODE = new LeetCode0019();

    @ParameterizedTest(name = "[{index}] case={0}, list={1}, n={2}")
    @MethodSource("testCases")
    void testRemoveNthFromEnd(String caseName, Integer[] listArray, int n, int[] expected) {
        ListNode listNode = LinkedListBuilder.build(listArray);
        ListNode result = LEET_CODE.removeNthFromEnd(listNode, n);

        if (expected == null) {
            assertNull(result, () -> "Case '%s' failed. list=%s, n=%d"
                    .formatted(caseName, Arrays.toString(listArray), n));
        } else {
            LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. list=%s, n=%d"
                    .formatted(caseName, Arrays.toString(listArray), n));
        }
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{1, 2, 3, 5}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{1, 2},
                        1,
                        new int[]{1}),

                // Example 3 from LeetCode: remove only node
                Arguments.of("example_3",
                        new Integer[]{1},
                        1,
                        null)
        );
    }
}
