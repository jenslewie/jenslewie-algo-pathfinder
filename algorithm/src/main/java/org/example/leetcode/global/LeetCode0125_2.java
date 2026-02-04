package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome">LeetCode 125: Valid Palindrome</a>
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. <br>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers with Character helpers. <br>
 * - Skip non-alphanumeric characters using built-in checks. <br>
 * - Compare lowercase characters while moving inward.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is visited at most once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0125_2 {

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
