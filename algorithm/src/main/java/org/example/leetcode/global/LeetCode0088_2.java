package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">...</a>
 */
public class LeetCode0088_2 {

    /**
     * Create temporary array approach
     * Time Complexity: O(m + n)
     * - We iterate through both arrays once to merge
     * <p>
     * Space Complexity: O(m + n)
     * - Creating a temporary array of size m + n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        for (int i = 0, j = 0, k = 0; i < m || j < n; ) {
            if (j == n) {
                nums[k++] = nums1[i++];
            } else if (i == m) {
                nums[k++] = nums2[j++];
            } else if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        System.arraycopy(nums, 0, nums1, 0, nums.length);
    }
}