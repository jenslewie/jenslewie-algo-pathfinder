package org.example.leetcode.global;

import org.example.builder.LinkedListBuilder;
import org.example.leetcode.LinkedListVerification;
import org.example.model.Pair;
import org.example.model.linkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class LeetCode0160Test {

    private LeetCode0160 leetCode;

    @BeforeEach
    public void init() {
        leetCode = new LeetCode0160();
    }

    @Test
    void test1() {
        Pair<ListNode, ListNode> pair = LinkedListBuilder.buildIntersectionNode(new Integer[]{4}, new Integer[]{5, 6}, new Integer[]{1, 8, 4, 5});
        int[] expectedValues = new int[]{1, 8, 4, 5};

        ListNode result = leetCode.getIntersectionNode(pair.first(), pair.second());
        LinkedListVerification.verify(expectedValues, result);

        result = leetCode.getIntersectionNode2(pair.first(), pair.second());
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test2() {
        Pair<ListNode, ListNode> pair = LinkedListBuilder.buildIntersectionNode(new Integer[]{1, 9, 1}, new Integer[]{3}, new Integer[]{2, 4});
        int[] expectedValues = new int[]{2, 4};

        ListNode result = leetCode.getIntersectionNode(pair.first(), pair.second());
        LinkedListVerification.verify(expectedValues, result);

        result = leetCode.getIntersectionNode2(pair.first(), pair.second());
        LinkedListVerification.verify(expectedValues, result);
    }

    @Test
    void test3() {
        ListNode head1 = LinkedListBuilder.build(new Integer[] {2, 6, 4});
        ListNode head2 = LinkedListBuilder.build(new Integer[] {1, 5});

        assertNull(leetCode.getIntersectionNode(head1, head2));
        assertNull(leetCode.getIntersectionNode2(head1, head2));
    }

}
