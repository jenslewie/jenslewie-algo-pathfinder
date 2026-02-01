package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reorder-list">...</a>
 * Stack-based approach
 */
public class LeetCode0143_2 {

    /**
     * Stack-based approach to reorder a linked list
     * Time Complexity: O(n)
     * - n: number of nodes in the linked list
     * - Find middle: O(n/2), push second half to stack: O(n/2), interleave: O(n/2)
     * <p>
     * Space Complexity: O(n/2)
     * - Stack stores approximately half of the nodes
     */
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