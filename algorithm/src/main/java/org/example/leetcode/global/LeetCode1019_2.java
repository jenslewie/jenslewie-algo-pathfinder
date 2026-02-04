package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list">LeetCode 1019: Next Greater Node In Linked List</a>
 * <p>
 * You are given the head of a linked list with n nodes. <br>
 * For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it. <br>
 * Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Reverse list + monotonic stack. <br>
 - Reverse the list, then compute next greater using a stack. <br>
 - Fill results from the end.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; linear passes.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and result array.
 */
public class LeetCode1019_2 {

    public int[] nextLargerNodes(ListNode head) {
        ListNode pre = null, cur = head;
        int i = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }

        int[] ans = new int[i];
        Deque<Integer> stack = new ArrayDeque<>();
        while (pre != null) {
            while (!stack.isEmpty() && stack.peek() <= pre.val) {
                stack.pop();
            }
            ans[--i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(pre.val);
            pre = pre.next;
        }

        return ans;
    }

}
