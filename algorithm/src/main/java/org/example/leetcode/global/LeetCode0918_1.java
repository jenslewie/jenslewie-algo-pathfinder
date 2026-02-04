package org.example.leetcode.global;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/maximum-sum-circular-subarray">LeetCode 918: Maximum Sum Circular Subarray</a>
 * <p>
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums. <br>
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n]. <br>
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Prefix sums with monotonic deque. <br>
 - Compute prefix sums over 2n and keep a deque of minima. <br>
 - Maintain a window size at most n.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Prefix sums and deque.
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
