package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses">LeetCode 20: Valid Parentheses</a>
 * <p>
 * Approach: Stack of opening brackets. <br>
 * - Push openings, and on a closing bracket check it matches the stack top. <br>
 * - Use a helper to map closing brackets to their openings.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores up to n characters in the worst case.
 */
public class LeetCode0020_2 {

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
