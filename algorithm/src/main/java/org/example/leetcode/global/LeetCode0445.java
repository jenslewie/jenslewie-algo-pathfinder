package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers-ii">LeetCode 445: Add Two Numbers II</a>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. <br>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself. <br>
 * Follow up: Could you solve it without reversing the input lists?
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two stacks for digit reversal. <br>
 * - Push digits of each list to stacks. <br>
 * - Pop and add with carry, building the result from front.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m, n: lengths of the lists; each node is processed once.
 * <p>
 * Space Complexity: O(m + n) <br>
 * - Stacks store all digits.
 */
public class LeetCode0445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int val = carry;
            if (!stack1.isEmpty()) {
                val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }
            carry = val / 10;
            ListNode temp = new ListNode(val % 10);
            temp.next = head.next;
            head.next = temp;
        }

        return head.next;
    }

}
