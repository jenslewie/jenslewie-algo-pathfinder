package org.example.leetcode.global;

/**
 * <a href="http://leetcode.cn/problems/valid-palindrome/">...</a>
 */
public class LeetCode0125_1 {

    /**
     * Time Complexity: O(n)
     * - n: length of the string
     * - We iterate through each character once at most
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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