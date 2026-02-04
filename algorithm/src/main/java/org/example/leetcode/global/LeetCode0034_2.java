package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">LeetCode 34: Find First and Last Position of Element in Sorted Array</a>
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. <br>
 * If target is not found in the array, return [-1, -1]. <br>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two binary searches. <br>
 * - First search finds the leftmost target index. <br>
 * - Second search finds the rightmost target index.
 * <p>
 * Time Complexity: O(log(n)) <br>
 * - n: length of the array; two binary searches.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space for pointers.
 */
public class LeetCode0034_2 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }

        int[] results = new int[2];
        results[0] = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        results[1] = right;

        return results;
    }
}
