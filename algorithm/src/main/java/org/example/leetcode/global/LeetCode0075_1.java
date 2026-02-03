package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/sort-colors">LeetCode 75: Sort Colors</a>
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
