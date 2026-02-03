package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/XltzEq">LeetCode LCR 018: Valid Palindrome</a>
 * <p>
 * Approach: Two pointers with skipping. <br>
 - Skip non-alphanumeric characters. <br>
 - Compare lowercase characters from both ends.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character visited once. <br>
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space. <br>
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
