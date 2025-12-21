package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class LeetCode0005 {

    public String longestPalindrome(String s) {
        String results = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            results = results.length() > s1.length() ? results : s1;
            results = results.length() > s2.length() ? results : s2;
        }
        return results;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
