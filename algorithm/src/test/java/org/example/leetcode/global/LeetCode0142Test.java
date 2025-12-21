package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0142Test {

    private LeetCode0142 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0142();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.buildCycle(new Integer[] {3, 2, 0, -4}, 1);

        ListNode result = leetCode.detectCycle(head);

        int[] expectedValues = new int[] {2, 0, -4, 2};
        LinkedListVerification.verifyCycle(expectedValues, result);
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.buildCycle(new Integer[] {1, 2}, 0);

        ListNode result = leetCode.detectCycle(head);

        int[] expectedValues = new int[] {1, 2, 1};
        LinkedListVerification.verifyCycle(expectedValues, result);
    }

    @Test
    void test3() {
        ListNode head = LinkedListBuilder.build(new Integer[] {1});

        assertNull(leetCode.detectCycle(head));
    }
}
