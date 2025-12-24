package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeetCode0083Test {

    private LeetCode0083 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0083();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 1, 2});
        ListNode result = leetCode.deleteDuplicates(head);
        LinkedListUtility.verify(new int[] {1, 2}, result);
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 1, 2, 3, 3});
        ListNode result = leetCode.deleteDuplicates(head);
        LinkedListUtility.verify(new int[] {1, 2, 3}, result);
    }

    @Test
    void test3() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 1, 1});
        ListNode result = leetCode.deleteDuplicates(head);
        LinkedListUtility.verify(new int[] {1}, result);
    }
}
