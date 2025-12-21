package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/move-zeroes/description/
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
