package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/subarray-product-less-than-k/description/
 */
public class LeetCode0713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, count = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            product *= nums[right++];
            while (product >= k && left < right) {
                product /= nums[left++];
            }
            count += right - left;
        }
        return count;
    }
}
