package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix">LeetCode 14: Longest Common Prefix</a>
 * <p>
 * Approach: Vertical scanning. <br>
 * - Compare characters column by column across all strings. <br>
 * - Stop at the first mismatch or when a string ends. <br>
 * <p>
 * Time Complexity: O(S) <br>
 * - S: total number of characters across all strings. <br>
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used. <br>
 */
public class LeetCode0014_2 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int m = strs.length;
        int n = strs[0].length();
        for (int j = 0; j < n; j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < m; i++) {
                if (strs[i].length() <= j || strs[i].charAt(j) != c) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }
}
