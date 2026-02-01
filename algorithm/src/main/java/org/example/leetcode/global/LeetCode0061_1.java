package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/rotate-list/
 */
public class LeetCode0061_1 {

    /**
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We traverse the list twice: once to calculate length, once to find the new tail
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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