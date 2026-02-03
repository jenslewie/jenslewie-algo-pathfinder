package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string">LeetCode 151: Reverse Words in a String</a>
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
