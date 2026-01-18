package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">...</a>
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
