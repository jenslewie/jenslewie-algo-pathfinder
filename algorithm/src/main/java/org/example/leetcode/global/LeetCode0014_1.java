package org.example.leetcode.global;

public class LeetCode0014_1 {

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