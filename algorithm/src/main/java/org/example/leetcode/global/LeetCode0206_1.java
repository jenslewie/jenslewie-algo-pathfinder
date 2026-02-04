package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list">LeetCode 206: Reverse Linked List</a>
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list. <br>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative pointer reversal. <br>
 * - Walk the list and reverse links one by one. <br>
 * - Track previous and current nodes.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0206_1 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
