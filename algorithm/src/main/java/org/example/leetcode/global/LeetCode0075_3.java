package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">...</a>
 */
public class LeetCode0075_3 {

    /**
     * Two-pass counting approach
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array twice
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for counters
     */
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