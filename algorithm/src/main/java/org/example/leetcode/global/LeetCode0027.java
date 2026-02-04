package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-element">LeetCode 27: Remove Element</a>
 * <p>
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val. <br>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things: <br>
 * Custom Judge: <br>
 * The judge will test your solution with the following code: <br>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Two pointers (slow/fast). <br>
 * - Fast scans all elements; slow writes non-target values in place. <br>
 * - The slow index is the new length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place update with constant extra space.
 */
public class LeetCode0027 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}
