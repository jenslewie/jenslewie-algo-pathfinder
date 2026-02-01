package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">...</a>
 */
public class LeetCode0088_3 {

    /**
     * Copy and sort approach
     * Time Complexity: O((m + n) * log(m + n))
     * - We copy elements and then sort the array
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space (assuming in-place sort)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}