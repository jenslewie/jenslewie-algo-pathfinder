package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome">LeetCode 125: Valid Palindrome</a>
 * <p>
 * Approach: Build cleaned string then compare to reverse. <br>
 * - Filter alphanumeric characters into a lowercase buffer. <br>
 * - Compare with its reversed copy.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; filtering and reversing are linear.
 * <p>
 * Space Complexity: O(n) <br>
 * - Buffer for the cleaned string and its reverse.
 */
public class LeetCode0125_3 {

    public boolean isPalindrome(String s) {
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().contentEquals(sgood_rev);
    }
}
