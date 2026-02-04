package org.example.leetcode.lcr;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/lMSNwu/">LCR 025: 两数相加</a>
 * <p>
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。<br>
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two stacks for digits. <br>
 * - Push digits of both lists onto stacks. <br>
 * - Pop and add with carry to build the result.
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
