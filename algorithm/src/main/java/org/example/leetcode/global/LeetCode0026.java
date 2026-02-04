package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">LeetCode 26: Remove Duplicates from Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums. <br>
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things: <br>
 * Custom Judge: <br>
 * The judge will test your solution with the following code: <br>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Difficulty: Easy
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
