package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii">LeetCode 82: Remove Duplicates from Sorted List II</a>
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Single pass with a sentinel and duplicate tracker. <br>
 * - Build the unique list directly. <br>
 * - Skip nodes that are part of duplicate runs.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for pointers.
 */
public class LeetCode0082_2 {

    public ListNode deleteDuplicates(ListNode head) {
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
