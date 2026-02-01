package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * Deque approach
 */
public class LeetCode1004_1 {

    /**
     * Deque approach to find maximum consecutive ones with at most k flips
     * Time Complexity: O(n)
     * - n: length of the input array
     * - Single pass through the array
     * <p>
     * Space Complexity: O(k)
     * - Deque stores at most k indices
     */
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