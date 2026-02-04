package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">LeetCode 88: Merge Sorted Array</a>
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. <br>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order. <br>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n. <br>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers from the end. <br>
 * - Compare from the back and fill nums1 from the end. <br>
 * - If nums2 remains, copy the rest.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m, n: lengths of the two arrays; each element is placed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place merge in nums1.
 */
public class LeetCode0088_1 {

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
