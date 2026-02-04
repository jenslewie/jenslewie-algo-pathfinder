package org.example.leetcode.global;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-circular-subarray">LeetCode 918: Maximum Sum Circular Subarray</a>
 * <p>
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums. <br>
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n]. <br>
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Streaming prefix sums with deque. <br>
 - Track prefix sums and maintain a deque of minima. <br>
 - Enforce a window size of n.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Deque stores prefix sums.
 */
public class LeetCode0918_2 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        var queue = new ArrayDeque<int[]>();
        int ans = Integer.MIN_VALUE;
        int preSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            preSum += nums[i % n];
            if (!queue.isEmpty()) {
                ans = Math.max(ans, preSum - queue.peekFirst()[1]);
            }
            while (!queue.isEmpty() && preSum < queue.peekLast()[1]) {
                queue.pollLast();
            }
            if (!queue.isEmpty() && i - queue.peekFirst()[0] == n) {
                queue.pollFirst();
            }
            queue.offerLast(new int[]{i, preSum});
        }
        return ans;
    }

}
