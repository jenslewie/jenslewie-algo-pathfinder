package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list">LeetCode 1019: Next Greater Node In Linked List</a>
 * <p>
 * You are given the head of a linked list with n nodes. <br>
 * For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it. <br>
 * Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Convert to array + monotonic stack. <br>
 - Store node values in a list. <br>
 - Use a stack of indices to find next greater values.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each index pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Array of values and stack.
 */
public class LeetCode1019_4 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] ans = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                ans[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }

        return ans;
    }

}
