package org.example.leetcode.global;

/**
 * <a href="http://leetcode.cn/problems/valid-palindrome/">...</a>
 */
public class LeetCode0125_2 {

    /**
     * Time Complexity: O(n)
     * - n: length of the string
     * - We iterate through each character once at most
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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