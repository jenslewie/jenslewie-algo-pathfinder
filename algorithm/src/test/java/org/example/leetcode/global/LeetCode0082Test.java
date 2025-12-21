package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0082Test {

    private LeetCode0082 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0082();
    }

    @Test
    void test1() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        ListNode result = leetCode.deleteDuplicates(head);
        LinkedListVerification.verify(new int[] {1, 2, 5}, result);

        head = LinkedListBuilder.build(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        result = leetCode.deleteDuplicates2(head);
        LinkedListVerification.verify(new int[] {1, 2, 5}, result);
    }

    @Test
    void test2() {
        ListNode head = LinkedListBuilder.build(new Integer[]{1, 1, 1, 2, 3});
        ListNode result = leetCode.deleteDuplicates(head);
        LinkedListVerification.verify(new int[] {2, 3}, result);

        head = LinkedListBuilder.build(new Integer[]{1, 1, 1, 2, 3});
        result = leetCode.deleteDuplicates2(head);
        LinkedListVerification.verify(new int[] {2, 3}, result);
    }

    @Test
    void test3() {
        ListNode head = LinkedListBuilder.build(new Integer[]{});
        assertNull(leetCode.deleteDuplicates(head));
        assertNull(leetCode.deleteDuplicates2(head));
    }

    @Test
    void test4() {
        ListNode head = LinkedListBuilder.build(null);
        assertNull(leetCode.deleteDuplicates(head));
        assertNull(leetCode.deleteDuplicates2(head));
    }

}
