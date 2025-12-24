package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeetCode0061Test {

    private LeetCode0061 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0061();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2, 3, 4, 5});
        ListNode result = leetCode.rotateRight(head, 2);
        LinkedListUtility.verify(new int[]{4, 5, 1, 2, 3}, result);
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2});
        ListNode result = leetCode.rotateRight(head, 0);
        LinkedListUtility.verify(new int[]{1, 2}, result);
    }
}
