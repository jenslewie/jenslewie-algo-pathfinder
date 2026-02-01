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

@DisplayName("LeetCode 142: Linked List Cycle II")
class LeetCode0142Test {

    private static final LeetCode0142 LEET_CODE = new LeetCode0142();

    @ParameterizedTest(name = "[{index}] case={0}, values={1}, pos={2}")
    @MethodSource("testCases")
    void testDetectCycle(String caseName, Integer[] values, int pos, int[] expected) {
        ListNode head;
        if (pos == -1) {
            // No cycle - use regular build
            head = LinkedListBuilder.build(values);
        } else {
            // Has cycle - use buildCycle
            head = LinkedListBuilder.buildCycle(values, pos);
        }
        ListNode result = LEET_CODE.detectCycle(head);

        if (expected == null) {
            assertNull(result, () -> "Case '%s' failed. values=%s, pos=%d"
                    .formatted(caseName, Arrays.toString(values), pos));
        } else {
            LinkedListUtility.verifyCycle(expected, result, () -> "Case '%s' failed. values=%s, pos=%d"
                    .formatted(caseName, Arrays.toString(values), pos));
        }
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // Example 1 from LeetCode
                Arguments.of("example_1",
                        new Integer[]{3, 2, 0, -4},
                        1,
                        new int[]{2, 0, -4, 2}),

                // Example 2 from LeetCode
                Arguments.of("example_2",
                        new Integer[]{1, 2},
                        0,
                        new int[]{1, 2, 1}),

                // Example 3 from LeetCode: no cycle
                Arguments.of("example_3",
                        new Integer[]{1},
                        -1,
                        null)
        );
    }
}
