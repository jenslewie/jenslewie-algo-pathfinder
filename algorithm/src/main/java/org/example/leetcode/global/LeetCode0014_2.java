package org.example.leetcode.global;

public class LeetCode0014_2 {

    /**
     * Time Complexity: O(S)
     * - S: sum of all characters in all strings
     * - In the worst case, we iterate through all characters of all strings
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space (excluding the output string)
     */
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
