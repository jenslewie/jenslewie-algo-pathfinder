package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses">LeetCode 20: Valid Parentheses</a>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. <br>
 * An input string is valid if:
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Stack of expected closing brackets. <br>
 * - Push the matching closing bracket when an opening bracket is seen. <br>
 * - On a closing bracket, verify it matches the stack top.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores up to n characters in the worst case.
 */
public class LeetCode0020_1 {

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
