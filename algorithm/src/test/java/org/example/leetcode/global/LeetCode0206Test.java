package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0206Test {

    private LeetCode0206 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0206();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2, 3, 4, 5});
        ListNode results = leetCode.reverseList(head);
        LinkedListUtility.verify(new int[]{5, 4, 3, 2, 1}, results);

        head = LinkedListBuilder.build(new Integer[]{1, 2, 3, 4, 5});
        results = leetCode.reverseList2(head);
        LinkedListUtility.verify(new int[]{5, 4, 3, 2, 1}, results);
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2});
        ListNode results = leetCode.reverseList(head);
        LinkedListUtility.verify(new int[]{2, 1}, results);

        head = LinkedListBuilder.build(new Integer[]{1, 2});
        results = leetCode.reverseList2(head);
        LinkedListUtility.verify(new int[]{2, 1}, results);
    }

    @Test
    void test3() {
        ListNode head = LinkedListBuilder.build(new Integer[]{});
        assertNull(leetCode.reverseList(head));
        assertNull(leetCode.reverseList2(head));
    }
}
