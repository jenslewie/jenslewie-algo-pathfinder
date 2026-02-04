package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/binary-search">LeetCode 704: Binary Search</a>
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1. <br>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Iterative binary search. <br>
 * - Maintain left/right bounds and shrink based on comparisons. <br>
 * - Return index when target is found.
 * <p>
 * Time Complexity: O(log(n)) <br>
 * - n: length of the array; halves search space each step.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
