package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/subarray-product-less-than-k">LeetCode 713: Subarray Product Less Than K</a>
 * <p>
 * Approach: Sliding window with product. <br>
 * - Expand right to multiply in new elements. <br>
 * - Shrink left while product >= k.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
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
