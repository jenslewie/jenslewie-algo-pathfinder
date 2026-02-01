package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array">...</a>
 * Approach 1: Two pointers from both ends
 */
public class LeetCode0977_1 {

    /**
     * Sort squares of a sorted array using two pointers from both ends
     * Time Complexity: O(n)
     * - n: length of nums
     * - Single pass through the array
     * <p>
     * Space Complexity: O(n)
     * - Result array of size n
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, p = n - 1;
        while (left <= right) {
            if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                result[p--] = nums[right] * nums[right];
                right--;
            } else {
                result[p--] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}