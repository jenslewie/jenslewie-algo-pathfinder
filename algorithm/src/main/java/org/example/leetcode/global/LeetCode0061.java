package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/rotate-list/
 */
public class LeetCode0061 {

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

    public ListNode rotateRight3(ListNode head, int k) {
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

    public ListNode rotateRight2(ListNode head, int k) {
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
