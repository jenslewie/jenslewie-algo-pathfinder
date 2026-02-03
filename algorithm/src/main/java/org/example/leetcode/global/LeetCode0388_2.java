package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/longest-absolute-file-path">LeetCode 388: Longest Absolute File Path</a>
 * <p>
 * Approach: Stack of path lengths. <br>
 * - Maintain a stack of cumulative lengths by depth. <br>
 * - Update max length when a file is parsed.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the input string; single pass parsing.
 * <p>
 * Space Complexity: O(d) <br>
 * - d: maximum directory depth.
 */
public class LeetCode0388_2 {

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
