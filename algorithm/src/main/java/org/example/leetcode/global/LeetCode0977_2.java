package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array">...</a>
 * Approach 2: Find partition point and merge
 */
public class LeetCode0977_2 {

    /**
     * Sort squares of a sorted array by finding partition point and merging
     * Time Complexity: O(n)
     * - n: length of nums
     * - Single pass through the array to find partition and merge
     * <p>
     * Space Complexity: O(n)
     * - Result array of size n
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int right = 0;
        while (right < n && nums[right] < 0) {
            right++;
        }
        int left = right - 1;
        for (int i = 0; i < n; i++) {
            if (left < 0) {
                result[i] = nums[right] * nums[right];
                right++;
            } else if (right > n - 1) {
                result[i] = nums[left] * nums[left];
                left--;
            } else if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                result[i] = nums[left] * nums[left];
                left--;
            } else {
                result[i] = nums[right] * nums[right];
                right++;
            }
        }
        return result;
    }
}