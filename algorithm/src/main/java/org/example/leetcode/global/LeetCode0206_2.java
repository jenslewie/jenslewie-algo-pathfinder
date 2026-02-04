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
 * Approach: Head-insertion with sentinel. <br>
 * - Repeatedly move the next node to the front of the list. <br>
 * - Uses a dummy node to simplify insertions.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is repositioned once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0206_2 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }
}
