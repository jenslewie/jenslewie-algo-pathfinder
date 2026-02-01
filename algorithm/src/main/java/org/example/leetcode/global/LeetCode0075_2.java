package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">...</a>
 */
public class LeetCode0075_2 {

    /**
     * Dutch National Flag algorithm - Three Pointers approach
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1, i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            } else if (nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            } else {
                i++;
            }

            if (i < p0) {
                i = p0;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}