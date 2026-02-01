package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class LeetCode0083_1 {

    /**
     * Single pass approach with sentinel node
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - We iterate through the list once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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
}