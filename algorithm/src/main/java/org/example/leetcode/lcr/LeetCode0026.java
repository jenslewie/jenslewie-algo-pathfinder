package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/LGjMqU">LeetCode LCR 026: Reorder List</a>
 * <p>
 * Approach: Reverse second half and merge. <br>
 - Find the middle, reverse the second half. <br>
 - Interleave nodes from both halves.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node visited a constant number of times. <br>
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place reordering. <br>
 */
public class LeetCode0026 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while (pre.next != null) {
            ListNode next1 = head.next;
            ListNode next2 = pre.next;
            head.next = pre;
            pre.next = next1;
            head = next1;
            pre = next2;
        }
    }

}
