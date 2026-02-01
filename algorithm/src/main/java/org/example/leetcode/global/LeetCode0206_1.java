package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list">...</a>
 */
public class LeetCode0206_1 {

    /**
     * Iterative approach to reverse a linked list
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We visit each node exactly once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}