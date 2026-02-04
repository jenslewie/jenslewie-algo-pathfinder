package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/lMSNwu/">LeetCode LCR 025: Add Two Numbers II</a>
 * <p>
 * Approach: Two stacks for digits. <br>
 - Push digits of both lists onto stacks. <br>
 - Pop and add with carry to build the result.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m, n: lengths of the lists; each node processed once.
 * <p>
 * Space Complexity: O(m + n) <br>
 * - Stacks store all digits.
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
