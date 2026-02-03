package org.example.leetcode.global;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-circular-subarray">LeetCode 918: Maximum Sum Circular Subarray</a>
 * <p>
 * Approach: Prefix sums with monotonic deque. <br>
 - Compute prefix sums over 2n and keep a deque of minima. <br>
 - Maintain a window size at most n.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each index is pushed/popped at most once. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Prefix sums and deque. <br>
 */
public class LeetCode0918_1 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[2 * n];
        for (int i = 0; i < 2 * n - 1; i++) {
            preSum[i + 1] = preSum[i] + nums[i % n];
        }

        var queue = new ArrayDeque<Integer>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 2 * n; i++) {
            int curSum = preSum[i];
            if (!queue.isEmpty()) {
                ans = Math.max(ans, curSum - preSum[queue.peekFirst()]);
            }
            while (!queue.isEmpty() && curSum < preSum[queue.peekLast()]) {
                queue.pollLast();
            }
            if (!queue.isEmpty() && i - queue.peekFirst() == n) {
                queue.pollFirst();
            }
            queue.offerLast(i);
        }
        return ans;
    }

}
