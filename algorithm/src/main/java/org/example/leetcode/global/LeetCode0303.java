package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-immutable">LeetCode 303: Range Sum Query - Immutable</a>
 * <p>
 * Given an integer array nums, handle multiple queries of the following type: <br>
 * Implement the NumArray class:
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Prefix sums. <br>
 * - Precompute prefix sums once in the constructor. <br>
 * - Answer range queries by subtracting prefix sums.
 * <p>
 * Time Complexity: O(n) build, O(1) per query <br>
 * - n: length of the array.
 * <p>
 * Space Complexity: O(n) <br>
 * - Prefix sum array stores n + 1 values.
 */
public class LeetCode0303 {

    private final int[] preSum;

    public LeetCode0303(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

}
