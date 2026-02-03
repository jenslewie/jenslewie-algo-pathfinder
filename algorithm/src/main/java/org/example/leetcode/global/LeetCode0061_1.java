package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/rotate-list">LeetCode 61: Rotate List</a>
 * <p>
 * Approach: Make a cycle, then break at the new tail. <br>
 * - Compute length and connect tail to head. <br>
 * - Move (len - k % len) steps to find the new tail.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; list is traversed a constant number of times.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0061_1 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        int add = len - k % len;
        if (add == len) {
            return head;
        }

        p.next = head;
        while (add-- > 0) {
            p = p.next;
        }

        ListNode result = p.next;
        p.next = null;
        return result;
    }
}
