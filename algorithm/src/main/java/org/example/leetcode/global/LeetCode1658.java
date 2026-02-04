package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero">LeetCode 1658: Minimum Operations to Reduce X to Zero</a>
 * <p>
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations. <br>
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window for longest subarray with sum = total - x. <br>
 * - Convert to finding the longest subarray to keep. <br>
 * - Use a window to match target sum.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
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
