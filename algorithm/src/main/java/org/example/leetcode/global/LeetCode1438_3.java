package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">LeetCode 1438: Longest Continuous Subarray With Absolute Diff <= Limit</a>
 * <p>
 * Approach: Sliding window with max/min heaps. <br>
 - Maintain heaps and lazy-remove outdated indices. <br>
 - Shrink when max - min exceeds limit.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - Heap operations are logarithmic.
 * <p>
 * Space Complexity: O(n) <br>
 * - Heaps store window values.
 */
public class LeetCode1438_3 {

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int[] maxQueue = new int[n];
        int[] minQueue = new int[n];
        int maxLeft = 0, maxRight = -1;
        int minLeft = 0, minRight = -1;
        int left = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            while (maxRight >= maxLeft && maxQueue[maxRight] < nums[i]) {
                maxRight--;
            }
            maxQueue[++maxRight] = nums[i];
            while (minRight >= minLeft && minQueue[minRight] > nums[i]) {
                minRight--;
            }
            minQueue[++minRight] = nums[i];

            if (maxQueue[maxLeft] - minQueue[minLeft] > limit) {
                if (nums[left] == maxQueue[maxLeft]) {
                    maxLeft++;
                }
                if (nums[left] == minQueue[minLeft]) {
                    minLeft++;
                }
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }

}
