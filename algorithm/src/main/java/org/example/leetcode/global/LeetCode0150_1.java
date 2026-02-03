package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation">LeetCode 150: Evaluate Reverse Polish Notation</a>
 * <p>
 * Approach: Array-based stack. <br>
 * - Push operands onto a stack; apply operators to the top two operands. <br>
 * - Store results back on the stack.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of tokens; each token is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack holds operands.
 */
public class LeetCode0150_1 {

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
