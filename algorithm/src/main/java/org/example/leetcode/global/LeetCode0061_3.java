package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/rotate-list/
 */
public class LeetCode0061_3 {

    /**
     * Time Complexity: O(n^2)
     * - n: number of nodes in the linked list
     * - We reverse parts of the list multiple times
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

        ListNode temp = head;
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < len; i++) {
            if (len - k == i) {
                temp = prev;
            }
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode head1 = reverseList(prev, k);
        ListNode head2 = reverseList(temp, len - k);

        p = head1;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head2;
        return head1;
    }

    private ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}