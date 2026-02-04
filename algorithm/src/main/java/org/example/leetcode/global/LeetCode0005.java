package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">LeetCode 5: Longest Palindromic Substring</a>
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Expand around center. <br>
 * - For each index, expand for odd and even centers. <br>
 * - Track the longest palindrome found.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: length of the string; each center expansion can scan the string.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
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
