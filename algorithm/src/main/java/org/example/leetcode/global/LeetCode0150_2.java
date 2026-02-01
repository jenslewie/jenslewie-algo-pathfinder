package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation">...</a>
 */
public class LeetCode0150_2 {

    /**
     * Integer Stack approach
     * Time Complexity: O(n)
     * - n: number of tokens
     * - We process each token once
     * <p>
     * Space Complexity: O(n)
     * - Stack can store up to n/2 operands in the worst case
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int a = stack.pop(), b = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}