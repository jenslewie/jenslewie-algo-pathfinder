package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k">LeetCode 862: Shortest Subarray with Sum at Least K</a>
 * <p>
 * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1. <br>
 * A subarray is a contiguous part of an array.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Prefix sums + monotonic deque. <br>
 - Maintain increasing prefix sums indices. <br>
 - Update answer when current sum minus front >= k.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Prefix sums and deque.
 */
public class LeetCode0862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int ans = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSum[i];
            while (!queue.isEmpty() && curSum - preSum[queue.peekFirst()] >= k) {
                ans = Math.min(ans, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSum[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        return ans < n + 1 ? ans : -1;
    }

}
