package org.example.leetcode.lcr;

/**
 * https://leetcode.cn/problems/2VG8Kg/
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
