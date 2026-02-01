package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">...</a>
 */
public class LeetCode0088_1 {

    /**
     * Two pointers from the end approach
     * Time Complexity: O(m + n)
     * - We iterate through both arrays once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}