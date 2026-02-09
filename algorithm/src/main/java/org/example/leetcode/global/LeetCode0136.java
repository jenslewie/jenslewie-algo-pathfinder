package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/single-number">LeetCode 136: Single Number</a>
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one. <br>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: XOR cancellation. <br>
 * - XOR equal numbers to cancel each duplicated pair (`a ^ a = 0`). <br>
 * - Accumulate all values so only the unique number remains.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of elements, each processed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses only one accumulator.
 */
public class LeetCode0136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }

}
