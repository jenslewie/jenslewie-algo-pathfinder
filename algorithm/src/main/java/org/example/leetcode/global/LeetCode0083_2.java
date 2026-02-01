package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class LeetCode0083_2 {

    /**
     * Two-pointer approach with sentinel node
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We iterate through the list once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public ListNode deleteDuplicates(ListNode head) {
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