package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class LeetCode0083 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode p = dummy;

        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode p1 = head, p2 = dummy;

        while (p1 != null) {
            if (p1.val == p2.val) {
                p2.next = p1.next;
                p1.next = null;
                p1 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return dummy.next;
    }

}
