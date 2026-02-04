package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation">LeetCode 150: Evaluate Reverse Polish Notation</a>
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation. <br>
 * Evaluate the expression. Return an integer that represents the value of the expression. <br>
 * Note that:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: String stack with parsing on each operation. <br>
 * - Push operands as strings; on operators, pop and compute. <br>
 * - Push results back as strings.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: number of tokens; repeated parsing adds overhead.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack holds operands.
 */
public class LeetCode0150_3 {

    public int evalRPN(String[] tokens) {
        String lastToken = tokens[tokens.length - 1];
        if (!"+".equals(lastToken) && !"-".equals(lastToken) && !"*".equals(lastToken) && !"/".equals(lastToken)) {
            return Integer.parseInt(lastToken);
        }

        int result = -201;
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                result = Integer.parseInt(stack.pop());
                result += Integer.parseInt(stack.pop());
                stack.push(String.valueOf(result));
            } else if ("-".equals(token)) {
                result = Integer.parseInt(stack.pop());
                result = Integer.parseInt(stack.pop()) - result;
                stack.push(String.valueOf(result));
            } else if ("*".equals(token)) {
                result = Integer.parseInt(stack.pop());
                result *= Integer.parseInt(stack.pop());
                stack.push(String.valueOf(result));
            } else if ("/".equals(token)) {
                result = Integer.parseInt(stack.pop());
                result = Integer.parseInt(stack.pop()) / result;
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }

        return result;
    }
}
