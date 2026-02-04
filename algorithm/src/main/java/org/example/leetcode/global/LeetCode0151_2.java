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
 * Approach: Split and rebuild. <br>
 * - Split by spaces and skip empty tokens. <br>
 * - Append words in reverse order.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; split and rebuild are linear.
 * <p>
 * Space Complexity: O(n) <br>
 * - Array of words plus StringBuilder.
 */
public class LeetCode0151_2 {

    public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
