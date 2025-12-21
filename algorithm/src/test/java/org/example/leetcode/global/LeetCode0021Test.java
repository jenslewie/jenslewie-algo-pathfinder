package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0021Test {

    private LeetCode0021 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0021();
    }

    @Test
    void test1() {
        ListNode list1 = LinkedListBuilder.build(new Integer[] {1, 3, 4, 5});
        ListNode list2 = LinkedListBuilder.build(new Integer[] {2, 5, 6});

        ListNode result = leetCode.mergeTwoLists(list1, list2);

        int[] expectedValues = new int[] {1, 2, 3, 4, 5, 5, 6};
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test2() {
        ListNode list1 = LinkedListBuilder.build(new Integer[] {});
        ListNode list2 = LinkedListBuilder.build(new Integer[] {2, 5, 6});

        ListNode result = leetCode.mergeTwoLists(list1, list2);

        int[] expectedValues = new int[] {2, 5, 6};
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test3() {
        ListNode list1 = LinkedListBuilder.build(new Integer[] {});
        ListNode list2 = LinkedListBuilder.build(new Integer[] {});

        ListNode result = leetCode.mergeTwoLists(list1, list2);

        assertNull(result);
    }
}
