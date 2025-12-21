package org.example.leetcode.lcr;

import org.example.builder.LinkedListBuilder;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode0140Test {

    private LeetCode0140 leetcode;

    @BeforeEach
    public void init() {
        leetcode = new LeetCode0140();
    }

    @Test
    void test() {
        ListNode head = LinkedListBuilder.build(new Integer[] {2, 4, 7, 8});

        ListNode result = leetcode.trainingPlan(head, 1);

        int[] expectedValues = new int[] {8};
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, result.val);
            result = result.next;
        }

    }
}
