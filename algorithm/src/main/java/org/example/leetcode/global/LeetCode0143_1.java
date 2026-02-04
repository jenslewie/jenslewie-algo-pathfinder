package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reorder-list">LeetCode 143: Reorder List</a>
 * <p>
 * You are given the head of a singly linked-list. The list can be represented as: <br>
 * Reorder the list to be on the following form: <br>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Reverse second half and merge. <br>
 * - Find the middle, reverse the second half. <br>
 * - Interleave nodes from the first and second halves.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited a constant number of times.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place reordering.
 */
public class LeetCode0143_1 {

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
