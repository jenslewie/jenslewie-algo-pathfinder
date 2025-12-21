package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeetCode0002Test {

    private LeetCode0002 leetCode;

    @BeforeEach
    public void setUp() {
        leetCode = new LeetCode0002();
    }

    @Test
    void test1() {
        ListNode l1 = LinkedListBuilder.build(new Integer[] {2, 4, 3});
        ListNode l2 = LinkedListBuilder.build(new Integer[] {5, 6, 4});

        ListNode result = leetCode.addTwoNumbers(l1, l2);

        LinkedListVerification.verify(new int[]{7, 0, 8}, result);
    }

    @Test
    void test2() {
        ListNode l1 = LinkedListBuilder.build(new Integer[] {0});
        ListNode l2 = LinkedListBuilder.build(new Integer[] {0});

        ListNode result = leetCode.addTwoNumbers(l1, l2);

        LinkedListVerification.verify(new int[]{0}, result);
    }

    @Test
    void test3() {
        ListNode l1 = LinkedListBuilder.build(new Integer[] {9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = LinkedListBuilder.build(new Integer[] {9, 9, 9, 9});

        ListNode result = leetCode.addTwoNumbers(l1, l2);

        LinkedListVerification.verify(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, result);
    }

}
