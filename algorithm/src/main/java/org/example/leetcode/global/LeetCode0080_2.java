package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/">...</a>
 */
public class LeetCode0080_2 {

    /**
     * Two-pointer approach with explicit boundary check
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }

        int slow = 2, fast = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}