package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/LGjMqU">...</a>
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
