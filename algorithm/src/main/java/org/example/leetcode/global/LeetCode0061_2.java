package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/rotate-list">LeetCode 61: Rotate List</a>
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Repeatedly move tail to head. <br>
 * - Rotate by moving the last node to the front k times. <br>
 * - Uses list traversal per rotation.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: number of nodes; repeated rotations each cost O(n).
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0061_2 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-101, head);
        while (head.next != null) {
            p = head.next;
            head.next = p.next;
            p.next = dummy.next;
            dummy.next = p;
        }
        head = dummy.next;

        for (int i = 0; i < k - 1; i++) {
            p = head.next;
            head.next = p.next;
            p.next = dummy.next;
            dummy.next = p;
        }

        ListNode temp = head;
        head = head.next;
        ListNode dummy2 = new ListNode(-101, head);
        while (head.next != null) {
            p = head.next;
            head.next = p.next;
            p.next = dummy2.next;
            dummy2.next = p;
        }

        temp.next = dummy2.next;
        return dummy.next;
    }
}
