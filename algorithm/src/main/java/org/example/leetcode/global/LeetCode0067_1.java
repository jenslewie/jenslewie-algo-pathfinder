package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/add-binary/
 */
public class LeetCode0067_1 {

    /**
     * Direct iteration approach
     * Time Complexity: O(max(m, n))
     * - m: length of string a
     * - n: length of string b
     * - We iterate through both strings once
     * <p>
     * Space Complexity: O(max(m, n))
     * - StringBuilder to store the result
     */
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