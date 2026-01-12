package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list">...</a>
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
