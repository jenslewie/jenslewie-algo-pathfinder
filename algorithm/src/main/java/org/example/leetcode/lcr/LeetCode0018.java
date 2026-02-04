package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/XltzEq">LCR 018: 验证回文串</a>
 * <p>
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。<br>
 * 本题中，将空字符串定义为有效的 回文串 。
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
