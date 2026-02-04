package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/sort-colors">LeetCode 75: Sort Colors</a>
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. <br>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively. <br>
 * You must solve this problem without using the library's sort function. <br>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two-pass counting by value. <br>
 * - First pass places all 0s, then all 1s. <br>
 * - Remaining elements are 2s.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is visited at most twice.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place swaps only.
 */
public class LeetCode0075_3 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p = 0;
        for (int num = 0; num < 2; num++) {
            for (int i = p; i < n; i++) {
                if (nums[i] == num) {
                    swap(nums, i, p);
                    p++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
