package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 */
public class LeetCode0876 {

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }

        return p2;
    }

}
