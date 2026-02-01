package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class LeetCode0082_1 {

    /**
     * Two-pointers dual-list approach
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We iterate through the list once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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
}