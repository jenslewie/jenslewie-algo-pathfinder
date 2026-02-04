package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/add-binary">LeetCode 67: Add Binary</a>
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two-pointer addition with carry. <br>
 * - Traverse both strings from right to left. <br>
 * - Sum bits with carry and build the result in reverse.
 * <p>
 * Time Complexity: O(max(m, n)) <br>
 * - m, n: lengths of the input strings.
 * <p>
 * Space Complexity: O(max(m, n)) <br>
 * - StringBuilder holds the result.
 */
public class LeetCode0067_1 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int val = carry;
            val += i >= 0 ? a.charAt(i) - '0' : 0;
            val += j >= 0 ? b.charAt(j) - '0' : 0;
            carry = val / 2;
            sb.append(val % 2);
        }
        return sb.reverse().toString();
    }
}
