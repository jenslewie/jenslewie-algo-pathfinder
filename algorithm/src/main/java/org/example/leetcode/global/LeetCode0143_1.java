package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reorder-list">...</a>
 * Reverse and merge approach
 */
public class LeetCode0143_1 {

    /**
     * Reverse and merge approach to reorder a linked list
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - Find middle: O(n), reverse second half: O(n/2), merge: O(n/2)
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre.next != null) {
            ListNode next1 = head.next;
            ListNode next2 = pre.next;
            pre.next = next1;
            head.next = pre;
            head = next1;
            pre = next2;
        }
    }
}