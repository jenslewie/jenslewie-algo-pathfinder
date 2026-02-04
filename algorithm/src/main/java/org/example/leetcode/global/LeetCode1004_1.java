package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii">LeetCode 1004: Max Consecutive Ones III</a>
 * <p>
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with zero count. <br>
 - Expand right; shrink left when zeros exceed k. <br>
 - Track maximum window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode1004_1 {

    public int longestOnes(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) {
                queue.offer(right - 1);
            }
            if (k < queue.size()) {
                maxLen = Math.max(maxLen, right - left - 1);
                left = queue.pollFirst() + 1;
            }
        }
        return Math.max(maxLen, right - left);
    }
}