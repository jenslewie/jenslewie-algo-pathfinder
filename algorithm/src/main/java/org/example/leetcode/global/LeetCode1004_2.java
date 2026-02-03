package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii">LeetCode 1004: Max Consecutive Ones III</a>
 * <p>
 * Approach: Sliding window with remaining flips. <br>
 - Decrease k when encountering 0, increase when moving left. <br>
 - Maintain the longest valid window.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; linear scan. <br>
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space. <br>
 */
public class LeetCode1004_2 {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int windowOneCount = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                windowOneCount++;
            }
            right++;
            while (right - left - windowOneCount > k) {
                if (nums[left] == 1) {
                    windowOneCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}