package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/lMSNwu/
 */
public class LeetCode0025 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int val = carry;
            if (!stack1.isEmpty()) {
                val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }

            carry = val / 10;
            ListNode cur = new ListNode(val % 10);
            cur.next = dummy.next;
            dummy.next = cur;
        }

        return dummy.next;
    }

}
