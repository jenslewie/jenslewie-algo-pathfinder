package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum">LeetCode 209: Minimum Size Subarray Sum</a>
 * <p>
 * Approach: Sliding window. <br>
 * - Expand right to reach or exceed target sum. <br>
 * - Shrink left to minimize window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0209 {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0, windowSum = 0;

        while (right < nums.length) {
            windowSum += nums[right++];
            while (windowSum >= target) {
                result = Math.min(result, right - left);
                windowSum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
