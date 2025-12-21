package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0019Test {
    private LeetCode0019 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0019();
    }

    @Test
    void test1() {
        ListNode listNode = LinkedListBuilder.build(new Integer[]{1, 2, 3, 4, 5});
        ListNode result = leetCode.removeNthFromEnd(listNode, 2);

        int[] expectedValues = {1, 2, 3, 5};
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test2() {
        ListNode listNode = LinkedListBuilder.build(new Integer[]{1, 2});
        ListNode result = leetCode.removeNthFromEnd(listNode, 1);

        int[] expectedValues = {1};
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test3() {
        ListNode listNode = LinkedListBuilder.build(new Integer[]{1});
        ListNode result = leetCode.removeNthFromEnd(listNode, 1);

        assertNull(result);
    }
}
