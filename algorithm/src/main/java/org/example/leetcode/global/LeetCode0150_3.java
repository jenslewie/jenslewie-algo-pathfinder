package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation">...</a>
 */
public class LeetCode0150_3 {

    /**
     * String Stack approach
     * Time Complexity: O(n^2)
     * - n: number of tokens
     * - Converting between integers and strings adds overhead
     * <p>
     * Space Complexity: O(n)
     * - Stack can store up to n/2 operands in the worst case
     */
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