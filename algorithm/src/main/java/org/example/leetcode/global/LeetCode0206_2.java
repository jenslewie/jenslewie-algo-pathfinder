package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list">...</a>
 */
public class LeetCode0206_2 {

    /**
     * Sentinel node approach to reverse a linked list
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We visit each node exactly once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers and dummy node
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }
}