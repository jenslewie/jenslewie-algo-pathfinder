package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">LeetCode 19: Remove Nth Node From End of List</a>
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head. <br>
 * Follow up: Could you do this in one pass?
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two pointers with a dummy node. <br>
 * - Advance the first pointer n+1 steps ahead. <br>
 * - Move both pointers until the first reaches the end, then remove the target node.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the list; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;

        for (int i = 0; i < n + 1; ++i) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return dummy.next;
    }

}
