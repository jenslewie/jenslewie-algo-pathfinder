package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/move-zeroes">LeetCode 283: Move Zeroes</a>
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. <br>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers with overwrite. <br>
 * - Move non-zero elements forward with a slow pointer. <br>
 * - Fill the remaining positions with zeros.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place update with constant extra space.
 */
public class LeetCode0283 {

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

}
