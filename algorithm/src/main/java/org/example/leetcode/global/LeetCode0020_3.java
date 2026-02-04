package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses">LeetCode 20: Valid Parentheses</a>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. <br>
 * An input string is valid if:
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Stack of bracket strings. <br>
 * - Push opening bracket strings. <br>
 * - On a closing bracket, compare with the stack top using string equality.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: length of the string; substring creation makes each step O(n) in total.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores up to n characters in the worst case.
 */
public class LeetCode0020_3 {

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if ("(".equals(c) || "[".equals(c) || "{".equals(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && (("(".equals(stack.peek()) && ")".equals(c)) ||
                        ("[".equals(stack.peek()) && "]".equals(c)) ||
                        ("{".equals(stack.peek()) && "}".equals(c)))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
