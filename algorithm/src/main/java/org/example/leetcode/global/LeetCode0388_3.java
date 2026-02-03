package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/longest-absolute-file-path">LeetCode 388: Longest Absolute File Path</a>
 * <p>
 * Approach: Split and stack of directory names. <br>
 * - Split input by newlines and track depth by tabs. <br>
 * - Compute path length when a file is seen.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the input string; splitting and scanning are linear.
 * <p>
 * Space Complexity: O(d) <br>
 * - d: maximum directory depth stored in the stack.
 */
public class LeetCode0388_3 {

    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Stack<String> stack = new Stack<>();
        for (String item : input.split("\n")) {
            int level = item.lastIndexOf("\t") + 1;
            while (level < stack.size()) {
                stack.pop();
            }
            stack.add(item.substring(level));
            if (item.contains(".")) {
                int sum = stack.stream().mapToInt(String::length).sum();
                sum += stack.size() - 1;
                maxLen = Math.max(maxLen, sum);
            }
        }
        return maxLen;
    }
}
