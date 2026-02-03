package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list">LeetCode 83: Remove Duplicates from Sorted List</a>
 * <p>
 * Approach: Single pass with a sentinel. <br>
 * - Compare current node with the next and skip duplicates. <br>
 * - Keep a moving pointer to rebuild the list in place.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for pointers.
 */
public class LeetCode0083_1 {

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
