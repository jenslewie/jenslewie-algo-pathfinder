package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/missing-number">LeetCode 268: Missing Number</a>
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Arithmetic series sum. <br>
 * - Compute expected sum of [0..n] with n*(n+1)/2. <br>
 * - Subtract actual array sum to get the missing number.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of elements in nums.
 * <p>
 * Space Complexity: O(1) <br>
 * - Uses constant extra variables.
 */
public class LeetCode0268_2 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }

}
