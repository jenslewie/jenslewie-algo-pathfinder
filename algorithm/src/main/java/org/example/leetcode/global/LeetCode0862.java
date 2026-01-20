package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k">...</a>
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
