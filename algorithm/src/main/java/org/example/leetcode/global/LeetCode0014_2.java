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
            for (int i = 0; i < m - 1; i++) {
                String currentStr = strs[i], nextStr = strs[i + 1];
                if (currentStr.length() <= j || nextStr.length() <= j || currentStr.charAt(j) != nextStr.charAt(j)) {
                    return currentStr.substring(0, j);
                }
            }
        }
        return strs[0];
    }
}