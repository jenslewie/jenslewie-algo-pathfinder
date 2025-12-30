package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reorder-list">...</a>
 */
public class LeetCode0143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre.next != null) {
            ListNode next1 = head.next;
            ListNode next2 = pre.next;
            pre.next = next1;
            head.next = pre;
            head = next1;
            pre = next2;
        }
    }

    public void reorderList2(ListNode head) {
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
