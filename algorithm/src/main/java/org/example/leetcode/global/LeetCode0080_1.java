package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii">LeetCode 80: Remove Duplicates from Sorted Array II</a>
 * <p>
 * Approach: Allow at most two duplicates. <br>
 * - Keep a slow pointer for the write position. <br>
 * - Accept a number if it is greater than nums[slow - 2].
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place update with constant extra space.
 */
public class LeetCode0080_1 {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int num : nums) {
            if (slow < 2 || num > nums[slow - 2]) {
                nums[slow++] = num;
            }
        }
        return slow;
    }
}
