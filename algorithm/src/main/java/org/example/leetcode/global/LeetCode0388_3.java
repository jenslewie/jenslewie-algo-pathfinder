package org.example.leetcode.global;

import java.util.Stack;

/**
 * String split approach for finding longest path in file system
 */
public class LeetCode0388_3 {

    /**
     * String split approach to find the longest absolute path to a file
     * Time Complexity: O(n)
     * - n: length of the input string
     * - Split the string and process each component
     * <p>
     * Space Complexity: O(d)
     * - d: maximum depth of the directory structure
     * - Stack to store directory names
     */
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