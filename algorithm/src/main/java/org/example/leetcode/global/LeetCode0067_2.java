package org.example.leetcode.global;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/add-binary/
 */
public class LeetCode0067_2 {

    /**
     * Stack-based approach
     * Time Complexity: O(max(m, n))
     * - m: length of string a
     * - n: length of string b
     * - We iterate through both strings once to build stacks and then process them
     * <p>
     * Space Complexity: O(m + n)
     * - Stacks to store the digits of both strings
     */
    public String addBinary(String a, String b) {
        Stack<Integer> stackA = new Stack<>();
        for (Character c : a.toCharArray()) {
            stackA.push(c - '0');
        }

        Stack<Integer> stackB = new Stack<>();
        for (Character c : b.toCharArray()) {
            stackB.push(c - '0');
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (!stackA.isEmpty() || !stackB.isEmpty() || carry > 0) {
            int val = carry;
            if (!stackA.isEmpty()) {
                val += stackA.pop();
            }
            if (!stackB.isEmpty()) {
                val += stackB.pop();
            }
            carry = val / 2;
            sb.append(val % 2);
        }

        return sb.reverse().toString();
    }
}