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

@DisplayName("LeetCode 83: Remove Duplicates from Sorted List")
class LeetCode0083Test {

    private static final LeetCode0083 LEET_CODE = new LeetCode0083();

    @ParameterizedTest(name = "[{index}] case={0}, head={1}")
    @MethodSource("testCases")
    void testDeleteDuplicates(String caseName, Integer[] headArray, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = LEET_CODE.deleteDuplicates(head);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. head=%s"
                .formatted(caseName, Arrays.toString(headArray)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{1, 1, 2},
                        new int[]{1, 2}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{1, 1, 2, 3, 3},
                        new int[]{1, 2, 3}),

                // Example 3: All duplicates
                Arguments.of("example_3",
                        new Integer[]{1, 1, 1},
                        new int[]{1})
        );
    }
}
