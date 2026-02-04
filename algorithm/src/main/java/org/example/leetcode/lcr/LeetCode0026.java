package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/LGjMqU/">LCR 026: 重排链表</a>
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：L0 → L1 → … → Ln - 1 → Ln <br>
 * 请将其重新排列后变为：L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … <br>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Reverse second half and merge. <br>
 * - Find the middle, reverse the second half. <br>
 * - Interleave nodes from both halves.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node visited a constant number of times.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place reordering.
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
