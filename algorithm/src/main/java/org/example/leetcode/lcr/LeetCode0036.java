package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/8Zf90G/">LeetCode LCR 036: Evaluate Reverse Polish Notation</a>
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation. <br>
 * Evaluate the expression. Return an integer that represents the value of the expression. <br>
 * Note that:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Array-based stack. <br>
 * - Push operands and apply operators to top two values. <br>
 * - Store results back on the stack.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of tokens; each token processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack holds operands.
 */
public class LeetCode0036 {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int top = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 1] = stack[top - 1] + stack[top];
                    top--;
                    break;
                case "-":
                    stack[top - 1] = stack[top - 1] - stack[top];
                    top--;
                    break;
                case "*":
                    stack[top - 1] = stack[top - 1] * stack[top];
                    top--;
                    break;
                case "/":
                    stack[top - 1] = stack[top - 1] / stack[top];
                    top--;
                    break;
                default:
                    stack[++top] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[top];
    }

}
