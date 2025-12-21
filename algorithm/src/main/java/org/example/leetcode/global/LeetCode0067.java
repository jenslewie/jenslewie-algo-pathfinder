package org.example.leetcode.global;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/add-binary/
 */
public class LeetCode0067 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int val = carry;
            val += i >= 0 ? a.charAt(i) - '0' : 0;
            val += j >= 0 ? b.charAt(j) - '0' : 0;
            carry = val / 2;
            sb.append(val % 2);
        }
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
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
