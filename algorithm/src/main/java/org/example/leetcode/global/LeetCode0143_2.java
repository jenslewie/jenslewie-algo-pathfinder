package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reorder-list">LeetCode 143: Reorder List</a>
 * <p>
 * You are given the head of a singly linked-list. The list can be represented as: <br>
 * Reorder the list to be on the following form: <br>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Stack-based interleaving. <br>
 * - Push the second half into a stack. <br>
 * - Pop and interleave nodes into the first half.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node is visited a constant number of times.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores about half the nodes.
 */
public class LeetCode0143_2 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            ListNode node = slow;
            slow = slow.next;
            node.next = null;
            stack.push(node);
        }

        ListNode p = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p.next = null;
    }
}
