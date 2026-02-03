package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list">LeetCode 83: Remove Duplicates from Sorted List</a>
 * <p>
 * Approach: Two pointers with a sentinel. <br>
 * - Use p2 as the last unique node, p1 as the scanner. <br>
 * - Skip nodes equal to the last unique value.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for pointers.
 */
public class LeetCode0083_2 {

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
