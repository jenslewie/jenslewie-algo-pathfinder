package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/rotate-list/
 */
public class LeetCode0061_2 {

    /**
     * Time Complexity: O(n^2)
     * - n: number of nodes in the linked list
     * - We repeatedly move nodes from the end to the front k times
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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