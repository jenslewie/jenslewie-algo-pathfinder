package org.example.leetcode.global;

/**
 * <a href="http://leetcode.cn/problems/valid-palindrome/">...</a>
 */
public class LeetCode0125_3 {

    /**
     * Time Complexity: O(n)
     * - n: length of the string
     * - We iterate through each character once to build the cleaned string
     * - And once to compare with reversed string
     * <p>
     * Space Complexity: O(n)
     * - Creating a new string buffer to store the cleaned string
     */
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