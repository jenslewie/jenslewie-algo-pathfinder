package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-element">LeetCode 27: Remove Element</a>
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
