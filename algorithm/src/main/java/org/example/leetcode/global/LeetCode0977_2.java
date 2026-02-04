package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array">LeetCode 977: Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Partition then merge. <br>
 - Find the first non-negative index. <br>
 - Merge squares from negative and non-negative sides.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; linear merge.
 * <p>
 * Space Complexity: O(n) <br>
 * - Output array.
 */
public class LeetCode0977_2 {

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