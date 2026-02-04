package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array">LeetCode 977: Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers from both ends. <br>
 - Compare absolute values at ends and fill from the back. <br>
 - Build a sorted squares array.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; single pass.
 * <p>
 * Space Complexity: O(n) <br>
 * - Output array.
 */
public class LeetCode0977_1 {

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