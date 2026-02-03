package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">LeetCode 88: Merge Sorted Array</a>
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
