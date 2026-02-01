package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array">...</a>
 */
public class LeetCode0034_1 {

    /**
     * Time Complexity: O(log n)
     * - n: length of the array
     * - We perform two binary searches, each taking O(log n)
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target);
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = leftBound(nums, target + 1) - 1;
        return new int[]{left, right};
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}