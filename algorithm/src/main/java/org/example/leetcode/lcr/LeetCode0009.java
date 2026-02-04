package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/ZVAVXX/">LeetCode LCR 009: Subarray Product Less Than K</a>
 * <p>
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
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
