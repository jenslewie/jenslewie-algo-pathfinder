package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array">LeetCode 26: Remove Duplicates from Sorted Array</a>
 * <p>
 * Approach: Two pointers (slow/fast). <br>
 * - Fast scans the array; slow tracks the last unique element. <br>
 * - When a new value appears, advance slow and overwrite.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place update with constant extra space.
 */
public class LeetCode0026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
