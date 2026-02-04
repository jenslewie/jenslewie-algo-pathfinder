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
 * Approach: Single pass with index stack. <br>
 - Maintain a stack of (value, index) with decreasing values. <br>
 - Update results when a greater value appears.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each node pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and list of results.
 */
public class LeetCode1019_3 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Deque<int[]> stack = new ArrayDeque<>();
        int i = 0;
        while (head != null) {
            list.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < head.val) {
                list.set(stack.pop()[1], head.val);
            }
            stack.push(new int[]{head.val, i++});
            head = head.next;
        }

        int[] ans = new int[i];
        for (int j = 0; j < i; j++) {
            ans[j] = list.get(j);
        }

        return ans;
    }

}
