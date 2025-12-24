package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeetCode0445Test {

    private LeetCode0445 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0445();
    }

    @Test
    void test1() {
        ListNode l1 = LinkedListBuilder.build(new Integer[] {2, 4, 3});
        ListNode l2 = LinkedListBuilder.build(new Integer[] {5, 6, 4});

        ListNode result = leetCode.addTwoNumbers(l1, l2);

        LinkedListUtility.verify(new int[]{8, 0, 7}, result);
    }

    @Test
    void test2() {
        ListNode l1 = LinkedListBuilder.build(new Integer[] {0});
        ListNode l2 = LinkedListBuilder.build(new Integer[] {0});

        ListNode result = leetCode.addTwoNumbers(l1, l2);

        LinkedListUtility.verify(new int[]{0}, result);
    }

    @Test
    void test3() {
        ListNode l1 = LinkedListBuilder.build(new Integer[] {7, 2, 4, 3});
        ListNode l2 = LinkedListBuilder.build(new Integer[] {5, 6, 4});

        ListNode result = leetCode.addTwoNumbers(l1, l2);

        LinkedListUtility.verify(new int[]{7, 8, 0, 7}, result);
    }
}
