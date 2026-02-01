package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/">...</a>
 */
public class LeetCode0080_1 {

    /**
     * Allow up to 2 duplicates approach
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
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