package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeetCode0086Test {

    private LeetCode0086 leetcode;

    @BeforeEach
    public void init() {
        leetcode = new LeetCode0086();
    }

    @Test
    void test1() {
        ListNode list = LinkedListBuilder.build(new Integer[]{1, 4, 3, 2, 5, 2});
        ListNode result = leetcode.partition(list, 3);

        int[] expectedValues = new int[] {1, 2, 2, 4, 3, 5};
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test2() {
        ListNode list = LinkedListBuilder.build(new Integer[]{2, 1});
        ListNode result = leetcode.partition(list, 2);

        int[] expectedValues = new int[] {1, 2};
        LinkedListVerification.verify(expectedValues, result);
    }
}
