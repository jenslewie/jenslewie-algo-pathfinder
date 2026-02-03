package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class LeetCode0151_1 {

    /**
     * Two-pointers approach
     * Time Complexity: O(n)
     * - n: length of the string
     * - We scan the string once
     * <p>
     * Space Complexity: O(n)
     * - StringBuilder to store the result
     */
    public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;
        int left = right;
        while (left >= 0) {
            if (s.charAt(left) == ' ') {
                left--;
                continue;
            }
            right = left;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s, left + 1, right + 1).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
