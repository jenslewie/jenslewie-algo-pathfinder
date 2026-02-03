package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii">LeetCode 80: Remove Duplicates from Sorted Array II</a>
 * <p>
 * Approach: Count occurrences while scanning. <br>
 * - Track count of the current value and write up to two copies. <br>
 * - Reset count when the value changes.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place update with constant extra space.
 */
public class LeetCode0080_3 {

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
