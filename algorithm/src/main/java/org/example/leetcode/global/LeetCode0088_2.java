package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">LeetCode 88: Merge Sorted Array</a>
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
