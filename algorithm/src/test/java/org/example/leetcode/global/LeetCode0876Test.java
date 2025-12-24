package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.utility.LinkedListUtility;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeetCode0876Test {

    private LeetCode0876 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0876();
    }

    @Test
    void test1() {
        ListNode listNode = LinkedListBuilder.build(new Integer[]{1, 2, 3, 4, 5});

        ListNode result = leetCode.middleNode(listNode);

        int[] expectedValues = new int[] {3, 4, 5};
        LinkedListUtility.verify(expectedValues, result);
    }

    @Test
    void test2() {
        ListNode listNode = LinkedListBuilder.build(new Integer[]{1, 2, 3, 4, 5, 6});

        ListNode result = leetCode.middleNode(listNode);

        int[] expectedValues = new int[] {4, 5, 6};
        LinkedListUtility.verify(expectedValues, result);
    }
}
