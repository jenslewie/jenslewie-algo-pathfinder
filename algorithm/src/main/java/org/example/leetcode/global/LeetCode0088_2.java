package org.example.leetcode.global;

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
 * Approach: Merge into a temporary array. <br>
 * - Use two pointers to merge nums1 and nums2 into a new array. <br>
 * - Copy the merged array back to nums1.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m, n: lengths of the two arrays; each element is processed once.
 * <p>
 * Space Complexity: O(m + n) <br>
 * - Temporary array to hold merged results.
 */
public class LeetCode0088_2 {

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
