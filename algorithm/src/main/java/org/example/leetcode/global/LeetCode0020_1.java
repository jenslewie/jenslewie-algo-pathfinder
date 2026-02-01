package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses">...</a>
 */
public class LeetCode0020_1 {

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
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}