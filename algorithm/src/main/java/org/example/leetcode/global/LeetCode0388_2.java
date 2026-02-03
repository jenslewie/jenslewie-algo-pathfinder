package org.example.leetcode.global;

import java.util.Stack;

/**
 * Stack-based approach for finding longest path in file system
 */
public class LeetCode0388_2 {

    /**
     * Stack-based approach to find the longest absolute path to a file
     * Time Complexity: O(n)
     * - n: length of the input string
     * - Single pass through the string
     * <p>
     * Space Complexity: O(d)
     * - d: maximum depth of the directory structure
     * - Stack to store path lengths at each level
     */
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0, ans = 0;
        Stack<Integer> stack = new Stack<>();

        while (pos < n) {
            int depth = 1;
            if (input.charAt(pos) == '\t') {
                while (input.charAt(pos) == '\t') {
                    pos++;
                    depth++;
                }
            }

            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos++;
                len++;
            }

            pos++;
            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }

        return ans;
    }
}
