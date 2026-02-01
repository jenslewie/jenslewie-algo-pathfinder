package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">...</a>
 */
public class LeetCode0075_1 {

    /**
     * Dutch National Flag algorithm - Two Pointers approach
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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