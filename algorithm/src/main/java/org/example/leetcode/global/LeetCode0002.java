package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/description/
 */
public class LeetCode0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        int x = 0;
        while (p1 != null || p2 != null || x > 0) {
            int val = x;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }

            x = val / 10;
            tail.next = new ListNode(val % 10);

            tail = tail.next;
        }

        return head.next;
    }

}
