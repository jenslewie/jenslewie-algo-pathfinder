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
 * Approach: Recursion with monotonic stack. <br>
 - Recurse to the end to know size. <br>
 - Use a decreasing stack to fill results on the way back.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Recursion stack and monotonic stack.
 */
public class LeetCode1019_1 {

    private int[] ans;
    private final Deque<Integer> stack = new ArrayDeque<>();

    public int[] nextLargerNodes(ListNode head) {
        f(head, 0);
        return ans;
    }

    private void f(ListNode node, int i) {
        if (node == null) {
            ans = new int[i];
            return;
        }
        f(node.next, i + 1);
        while (!stack.isEmpty() && stack.peek() <= node.val) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            ans[i] = stack.peek();
        }
        stack.push(node.val);
    }

}
