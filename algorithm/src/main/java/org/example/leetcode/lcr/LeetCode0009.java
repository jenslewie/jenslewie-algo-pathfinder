package org.example.leetcode.lcr;

/**
 * https://leetcode.cn/problems/ZVAVXX/
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
