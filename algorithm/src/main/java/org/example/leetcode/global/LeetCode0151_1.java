package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string">LeetCode 151: Reverse Words in a String</a>
 * <p>
 * Approach: Two pointers scanning from the end. <br>
 * - Skip trailing spaces, then extract words backwards. <br>
 * - Append words to a StringBuilder.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is visited once.
 * <p>
 * Space Complexity: O(n) <br>
 * - StringBuilder holds the result.
 */
public class LeetCode0151_1 {

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
