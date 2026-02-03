package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list">LeetCode 1019: Next Greater Node In Linked List</a>
 * <p>
 * Approach: Convert to array + monotonic stack. <br>
 - Store node values in a list. <br>
 - Use a stack of indices to find next greater values.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of nodes; each index pushed/popped once. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Array of values and stack. <br>
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
