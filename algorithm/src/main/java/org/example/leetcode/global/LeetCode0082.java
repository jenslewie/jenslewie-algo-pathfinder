package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class LeetCode0082 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy1 = new ListNode(-101);
        ListNode dummy2 = new ListNode(-101);
        ListNode p = head, p1 = dummy1, p2 = dummy2;

        int lastValue = -101;
        while (p != null) {
            if (p.next != null && p.val != p.next.val) {
                if (p.val != lastValue) {
                    p1.next = p;
                    p1 = p1.next;
                } else {
                    p2.next = p;
                    p2 = p2.next;
                }
            } else if (p.next == null && p.val != lastValue) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            lastValue = p.val;
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        return dummy1.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyUniq = new ListNode(-101);
        ListNode p = head, pUniq = dummyUniq, pDup = new ListNode(-101);

        while (p != null) {
            if (p.next != null && p.val == p.next.val || p.val == pDup.val) {
                pDup.next = p;
                pDup = pDup.next;
            } else {
                pUniq.next = p;
                pUniq = pUniq.next;
            }

            p = p.next;
            pDup.next = null;
            pUniq.next = null;
        }

        return dummyUniq.next;
    }

}
