package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list">...</a>
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
