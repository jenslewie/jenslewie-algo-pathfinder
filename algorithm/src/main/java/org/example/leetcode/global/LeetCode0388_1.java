package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/longest-absolute-file-path">LeetCode 388: Longest Absolute File Path</a>
 * <p>
 * Approach: Depth-based length tracking. <br>
 * - Track the cumulative length at each depth. <br>
 * - Update the maximum when a file is encountered.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the input string; single pass parsing.
 * <p>
 * Space Complexity: O(d) <br>
 * - d: maximum directory depth.
 */
public class LeetCode0388_1 {

    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0, ans = 0;
        int[] level = new int[n + 1];

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
            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }

        return ans;
    }
}
