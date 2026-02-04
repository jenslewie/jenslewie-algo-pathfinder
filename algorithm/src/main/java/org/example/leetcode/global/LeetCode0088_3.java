package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array">LeetCode 88: Merge Sorted Array</a>
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. <br>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order. <br>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n. <br>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * <p>
 * Difficulty: Easy
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
