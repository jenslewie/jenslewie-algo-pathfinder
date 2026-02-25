package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k">LeetCode 560: Subarray Sum Equals K</a>
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k. <br>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Brute-force enumeration of subarrays ending at each index. <br>
 * - For each start index, walk backward to accumulate sums of all subarrays ending at start. <br>
 * - Count each sum equal to k.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: array length; all start/end pairs are checked.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra variables only.
 */
public class LeetCode0560_1 {

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
