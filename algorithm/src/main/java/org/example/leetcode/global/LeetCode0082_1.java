package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii">LeetCode 82: Remove Duplicates from Sorted List II</a>
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two lists for unique and duplicate nodes. <br>
 * - Track the last seen value and split nodes into unique/duplicate lists. <br>
 * - Return the unique list.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for pointers.
 */
public class LeetCode0082_1 {

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
