package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome">LeetCode 125: Valid Palindrome</a>
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. <br>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers with manual validation. <br>
 * - Move pointers inward, skipping non-alphanumeric characters. <br>
 * - Compare lowercase characters for equality.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is visited at most once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0125_1 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValid(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        if (c - 'a' >= 0 && c - 'z' <= 0) {
            return true;
        }
        return c - '0' >= 0 && c - '9' <= 0;
    }
}
