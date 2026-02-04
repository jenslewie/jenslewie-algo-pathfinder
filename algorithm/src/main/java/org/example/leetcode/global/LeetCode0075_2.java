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
 * Approach: Three-pointer Dutch National Flag. <br>
 * - Keep low for 0s, high for 2s, and scan with i. <br>
 * - Swap elements into the correct region.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place swaps only.
 */
public class LeetCode0075_2 {

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
