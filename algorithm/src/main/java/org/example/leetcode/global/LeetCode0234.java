package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list">LeetCode 234: Palindrome Linked List</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Half traversal with deque. <br>
 * - Use fast/slow pointers to reach the middle. <br>
 * - Compare second half with values stored from the first half.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Deque stores the first half values.
 */
public class LeetCode0234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Deque<Integer> deque = new ArrayDeque<>();
        while (fast != null && fast.next != null) {
            deque.addFirst(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (deque.pollFirst() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

}
