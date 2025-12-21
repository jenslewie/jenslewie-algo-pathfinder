package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/partition-list/description/
 */
public class LeetCode0086 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1, p2 = dummy2;

        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = null;

            if (cur.val < x) {
                p1.next = cur;
                p1 = p1.next;
            } else {
                p2.next = cur;
                p2 = p2.next;
            }
        }

        p1.next = dummy2.next;

        return dummy1.next;
    }

}
