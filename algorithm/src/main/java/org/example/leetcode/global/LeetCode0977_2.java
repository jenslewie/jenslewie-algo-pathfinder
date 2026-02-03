package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array">LeetCode 977: Squares of a Sorted Array</a>
 * <p>
 * Approach: Partition then merge. <br>
 - Find the first non-negative index. <br>
 - Merge squares from negative and non-negative sides.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; linear merge. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Output array. <br>
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