package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 141: Linked List Cycle")
class LeetCode0141Test {

    private static final LeetCode0141 SOLUTION = new LeetCode0141();

    @ParameterizedTest(name = "[{index}] case={0}, values={1}, pos={2}")
    @MethodSource("testCases")
    void testHasCycle(String caseName, Integer[] values, int pos, boolean expected) {
        ListNode head;
        if (pos == -1) {
            head = LinkedListBuilder.build(values);
        } else {
            head = LinkedListBuilder.buildCycle(values, pos);
        }
        boolean actual = SOLUTION.hasCycle(head);
        assertEquals(expected, actual, () -> "Case '%s' failed. values=%s, pos=%d"
                .formatted(caseName, Arrays.toString(values), pos));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("cycle_at_1", new Integer[]{3, 2, 0, -4}, 1, true),
                Arguments.of("cycle_at_0", new Integer[]{1, 2}, 0, true),
                Arguments.of("no_cycle", new Integer[]{1}, -1, false)
        );
    }
}
