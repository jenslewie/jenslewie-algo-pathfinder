package org.example.leetcode.global;

import org.example.learning.queue.MonotonicQueue;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">...</a>
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
