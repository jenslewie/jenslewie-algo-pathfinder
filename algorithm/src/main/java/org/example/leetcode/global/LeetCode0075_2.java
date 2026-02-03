package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/sort-colors">LeetCode 75: Sort Colors</a>
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
