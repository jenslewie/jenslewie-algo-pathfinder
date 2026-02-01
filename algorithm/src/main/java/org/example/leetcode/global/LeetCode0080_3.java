package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/">...</a>
 */
public class LeetCode0080_3 {

    /**
     * Counter-based approach with explicit tracking
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array once
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers and counter
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0, count = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                nums[++slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                count = 0;
            }
        }
        return slow + 1;
    }
}