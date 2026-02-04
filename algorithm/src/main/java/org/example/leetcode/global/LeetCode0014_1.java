package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix">LeetCode 14: Longest Common Prefix</a>
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings. <br>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Horizontal scanning. <br>
 * - Start with the first string as the current prefix. <br>
 * - Iteratively shrink the prefix by comparing it with each subsequent string. <br>
 * <p>
 * Time Complexity: O(S) <br>
 * - S: total number of characters across all strings.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0014_1 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int m = strs.length;
        String commonPrefix = strs[0];
        for (int i = 1; i < m; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.isEmpty()) {
                break;
            }
        }
        return commonPrefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
