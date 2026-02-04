package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/2VG8Kg/">LCR 008: 长度最小的子数组</a>
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。<br>
 * 找出该数组中满足其总和大于等于 target 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window. <br>
 * - Expand right to reach or exceed target sum. <br>
 * - Shrink left to minimize window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0008 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            windowSum += nums[right++];
            while (windowSum >= target && left < right) {
                result = Math.min(result, right - left);
                windowSum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
