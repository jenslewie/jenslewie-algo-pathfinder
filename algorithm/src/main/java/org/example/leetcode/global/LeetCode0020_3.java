package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses">...</a>
 */
public class LeetCode0020_3 {

    /**
     * Time Complexity: O(n^2)
     * - n: length of the string
     * - For each character, we use substring() which takes O(n) time
     * - Total: O(n^2)
     * <p>
     * Space Complexity: O(n)
     * - Stack can hold up to n/2 characters in worst case (all opening brackets)
     * - Overall: O(n)
     */
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