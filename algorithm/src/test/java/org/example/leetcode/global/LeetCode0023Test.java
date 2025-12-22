package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0023Test {

    private LeetCode0023 leetcode;

    @BeforeEach
    public void init() {
        leetcode = new LeetCode0023();
    }

    @Test
    void test1() {
        ListNode[] list = new ListNode[]{
                LinkedListBuilder.build(new Integer[]{1, 4, 5}),
                LinkedListBuilder.build(new Integer[]{1, 3, 4}),
                LinkedListBuilder.build(new Integer[]{2, 6})
        };

        ListNode result = leetcode.mergeKLists(list);

        int[] expectedValues = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test2() {
        ListNode[] list = new ListNode[]{};
        ListNode result = leetcode.mergeKLists(list);
        assertNull(result);
    }

    @Test
    void test3() {
        ListNode[] list = new ListNode[]{
                LinkedListBuilder.build(new Integer[]{}),
                LinkedListBuilder.build(new Integer[]{})
        };
        ListNode result = leetcode.mergeKLists(list);
        assertNull(result);
    }

    @Test
    void test4() {
        ListNode[] list = new ListNode[]{
                LinkedListBuilder.build(new Integer[]{1, 4, 5}),
                LinkedListBuilder.build(new Integer[]{2, 3, 4}),
                LinkedListBuilder.build(new Integer[]{3, 6}),
                LinkedListBuilder.build(new Integer[]{4, 6, 7}),
                LinkedListBuilder.build(new Integer[]{5, 6, 9}),
                LinkedListBuilder.build(new Integer[]{6, 9}),
                LinkedListBuilder.build(new Integer[]{7, 10, 11}),
                LinkedListBuilder.build(new Integer[]{8, 9, 10}),
                LinkedListBuilder.build(new Integer[]{9, 16, 17, 18}),
                LinkedListBuilder.build(new Integer[]{10, 11, 15})
        };
        ListNode result = leetcode.mergeKLists2(list);
        int[] expectedValues = new int[]{1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 15, 16, 17, 18};
        LinkedListVerification.verify(expectedValues, result);
    }
}
