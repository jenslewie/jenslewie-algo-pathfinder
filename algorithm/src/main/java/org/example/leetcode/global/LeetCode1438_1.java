package org.example.leetcode.global;

import org.example.learning.queue.MonotonicQueue;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">LeetCode 1438: Longest Continuous Subarray With Absolute Diff <= Limit</a>
 * <p>
 * Approach: Sliding window with two deques. <br>
 - Maintain max deque and min deque. <br>
 - Shrink window when max - min exceeds limit.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each index is pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Deques store indices.
 */
public class LeetCode1438_1 {

    public int longestSubarray(int[] nums, int limit) {
        MonotonicQueue<Integer> queue = new MonotonicQueue<>();
        for (int num : nums) {
            queue.push(num);
            if (queue.max() - queue.min() > limit) {
                queue.pop();
            }
        }
        return queue.size();
    }

}
