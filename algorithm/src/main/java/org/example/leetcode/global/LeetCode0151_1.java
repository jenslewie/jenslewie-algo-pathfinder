package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string">LeetCode 151: Reverse Words in a String</a>
 * <p>
 * Given an input string s, reverse the order of the words. <br>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space. <br>
 * Return a string of the words in reverse order concatenated by a single space. <br>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces. <br>
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 * <p>
 * Difficulty: Medium
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
