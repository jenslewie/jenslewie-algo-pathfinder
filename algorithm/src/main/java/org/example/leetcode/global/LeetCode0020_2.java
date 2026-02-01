package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses">...</a>
 */
public class LeetCode0020_2 {

    /**
     * Time Complexity: O(n)
     * - n: length of the string
     * - We iterate through each character once
     * <p>
     * Space Complexity: O(n)
     * - Stack can hold up to n/2 characters in worst case (all opening brackets)
     * - Overall: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}