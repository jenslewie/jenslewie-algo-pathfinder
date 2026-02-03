package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation">LeetCode 150: Evaluate Reverse Polish Notation</a>
 * <p>
 * Approach: Stack of integers. <br>
 * - Push operands, pop two when an operator is seen. <br>
 * - Push the computed result back to the stack.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of tokens; each token is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack holds operands.
 */
public class LeetCode0150_2 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
