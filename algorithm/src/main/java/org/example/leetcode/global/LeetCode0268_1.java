package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/missing-number">LeetCode 268: Missing Number</a>
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: XOR cancellation. <br>
 * - XOR all values in nums and all values in [0..n]. <br>
 * - Paired values cancel and the remaining value is the missing number.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of elements in nums.
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses constant extra variables.
 */
public class LeetCode0268_1 {

    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int num : nums) {
            ans ^= num;
        }
        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        return ans;
    }

}
