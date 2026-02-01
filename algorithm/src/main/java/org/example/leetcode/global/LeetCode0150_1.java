package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation">...</a>
 */
public class LeetCode0150_1 {

    /**
     * Array-based stack approach
     * Time Complexity: O(n)
     * - n: number of tokens
     * - We process each token once
     * <p>
     * Space Complexity: O(n)
     * - Array stack can store up to n/2 operands in the worst case
     */
    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int top = -1;
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int a = stack[top--];
                switch (token) {
                    case "+":
                        stack[top] += a;
                        break;
                    case "-":
                        stack[top] -= a;
                        break;
                    case "*":
                        stack[top] *= a;
                        break;
                    case "/":
                        stack[top] /= a;
                        break;
                }
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }
}