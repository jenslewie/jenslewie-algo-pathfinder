package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * Sliding window approach
 */
public class LeetCode1004_2 {

    /**
     * Sliding window approach to find maximum consecutive ones with at most k flips
     * Time Complexity: O(n)
     * - n: length of the input array
     * - Single pass through the array with two pointers
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for pointers and counters
     */
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