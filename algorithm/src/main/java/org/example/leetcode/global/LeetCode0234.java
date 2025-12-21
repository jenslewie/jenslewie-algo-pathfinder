package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/description/
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
