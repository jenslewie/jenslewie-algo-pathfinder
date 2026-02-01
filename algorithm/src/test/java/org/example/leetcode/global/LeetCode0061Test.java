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

@DisplayName("LeetCode 61: Rotate List")
class LeetCode0061Test {

    private static final LeetCode0061 LEET_CODE = new LeetCode0061();

    @ParameterizedTest(name = "[{index}] case={0}, head={1}, k={2}")
    @MethodSource("testCases")
    void testRotateRight(String caseName, Integer[] headArray, int k, int[] expected) {
        ListNode head = LinkedListBuilder.build(headArray);
        ListNode result = LEET_CODE.rotateRight(head, k);
        LinkedListUtility.verify(expected, result, () -> "Case '%s' failed. head=%s, k=%d"
                .formatted(caseName, Arrays.toString(headArray), k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{4, 5, 1, 2, 3}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{1, 2},
                        0,
                        new int[]{1, 2})
        );
    }
}
