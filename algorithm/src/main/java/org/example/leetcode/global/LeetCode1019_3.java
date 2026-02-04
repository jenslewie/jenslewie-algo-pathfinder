package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list">LeetCode 1019: Next Greater Node In Linked List</a>
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
