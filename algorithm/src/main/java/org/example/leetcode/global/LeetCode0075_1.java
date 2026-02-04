package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/sort-colors">LeetCode 75: Sort Colors</a>
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. <br>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively. <br>
 * You must solve this problem without using the library's sort function. <br>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two-pointer Dutch National Flag (0/1 boundaries). <br>
 * - Maintain two pointers for positions of 0s and 1s. <br>
 * - Swap as you scan to group colors.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place swaps only.
 */
public class LeetCode0075_1 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
