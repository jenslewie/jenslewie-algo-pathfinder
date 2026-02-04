package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/ZVAVXX/">LCR 009: 乘积小于K的子数组</a>
 * <p>
 * 给定一个正整数数组 nums 和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with product. <br>
 * - Expand right and multiply. <br>
 * - Shrink left while product >= k.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0009 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int windowProduct = 1;
        int result = 0;

        while (right < nums.length) {
            windowProduct *= nums[right++];
            while (windowProduct >= k && left < right) {
                windowProduct /= nums[left++];
            }
            result += right - left;
        }

        return result;
    }

}
