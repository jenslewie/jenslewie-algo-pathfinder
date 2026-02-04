package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/XltzEq">LeetCode LCR 018: Valid Palindrome</a>
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. <br>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers with skipping. <br>
 * - Skip non-alphanumeric characters. <br>
 * - Compare lowercase characters from both ends.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0018 {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

}
