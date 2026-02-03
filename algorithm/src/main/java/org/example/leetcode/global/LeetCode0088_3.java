package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">LeetCode 88: Merge Sorted Array</a>
 * <p>
 * Approach: Copy then sort. <br>
 * - Copy nums2 into the trailing slots of nums1. <br>
 * - Sort nums1 in place.
 * <p>
 * Time Complexity: O((m + n) * log(m + n)) <br>
 * - Sorting dominates the runtime.
 * <p>
 * Space Complexity: O(1) <br>
 * - Sort is in place for the array.
 */
public class LeetCode0088_3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
