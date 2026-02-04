package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/remove-k-digits">LeetCode 402: Remove K Digits</a>
 * <p>
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Array-based stack of indices. <br>
 * - Maintain increasing digits with index stack. <br>
 * - Trim remaining digits if k remains.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of digits; each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack array stores indices.
 */
public class LeetCode0402_3 {

    public String removeKdigits(String num, int k) {
        int[] stack = new int[num.length() + 1];
        char[] nums = num.toCharArray();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (index > 0 && k > 0 && nums[stack[index]] > nums[i]) {
                index--;
                k--;
            }
            stack[++index] = i;
        }

        if (k > 0) {
            index = Math.max(0, index - k);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= index; i++) {
            if (sb.isEmpty() && nums[stack[i]] == '0') {
                continue;
            }
            sb.append(nums[stack[i]]);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

}
