package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 */
public class LeetCode1658 {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }

        int left = 0, right = 0, windowSum = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < nums.length) {
            windowSum += nums[right++];
            while (windowSum > sum - x) {
                windowSum -= nums[left++];
            }
            if (windowSum == sum - x) {
                maxLen = Math.max(maxLen, right - left);
            }
        }

        return maxLen == Integer.MIN_VALUE ? -1 : nums.length - maxLen;
    }

}
