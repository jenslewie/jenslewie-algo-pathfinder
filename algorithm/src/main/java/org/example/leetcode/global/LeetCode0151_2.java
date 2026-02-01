package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class LeetCode0151_2 {

    /**
     * Split and reverse approach
     * Time Complexity: O(n)
     * - n: length of the string
     * - Splitting and joining operations take linear time
     * <p>
     * Space Complexity: O(n)
     * - Array to store the split words and StringBuilder for result
     */
    public String reverseWords(String s) {
        s = s.trim();
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