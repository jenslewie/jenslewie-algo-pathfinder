package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/add-binary">LeetCode 67: Add Binary</a>
 * <p>
 * Approach: Stack-based addition. <br>
 * - Push digits of both strings onto stacks. <br>
 * - Pop and sum with carry to build the result.
 * <p>
 * Time Complexity: O(max(m, n)) <br>
 * - m, n: lengths of the input strings.
 * <p>
 * Space Complexity: O(m + n) <br>
 * - Stacks store all digits.
 */
public class LeetCode0067_2 {

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
