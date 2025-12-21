package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class LeetCode0209 {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0, windowSum = 0;

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
