package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">LeetCode 1438: Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</a>
 * <p>
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with TreeMap. <br>
 - Track counts in a TreeMap to get min/max. <br>
 - Shrink when max - min exceeds limit.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - TreeMap operations are logarithmic.
 * <p>
 * Space Complexity: O(n) <br>
 * - TreeMap stores window values.
 */
public class LeetCode1438_2 {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int left = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!maxQueue.isEmpty() && nums[maxQueue.getLast()] < nums[i]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(i);
            while (!minQueue.isEmpty() && nums[minQueue.getLast()] > nums[i]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(i);

            if (nums[maxQueue.getFirst()] - nums[minQueue.getFirst()] > limit) {
                if (left == maxQueue.getFirst()) {
                    maxQueue.pollFirst();
                }
                if (left == minQueue.getFirst()) {
                    minQueue.pollFirst();
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }

}
