package org.example.leetcode.lcr;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof">...</a>
 * Monotonic deque approach
 */
public class LeetCode0183_1 {

    /**
     * Monotonic deque approach to find maximum altitude in sliding window
     * Time Complexity: O(n)
     * - n: length of the input array
     * - Each element is added and removed from the deque at most once
     * <p>
     * Space Complexity: O(k)
     * - Where k is the window size, for storing elements in the deque
     */
    public int[] maxAltitude(int[] heights, int limit) {
        int n = heights.length;
        if (n == 0 || limit == 0) {
            return new int[0];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[n - limit + 1];

        for (int i = 1 - limit, j = 0; j < n; i++, j++) {
            if (i > 0 && queue.peekFirst() == heights[i - 1]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < heights[j]) {
                queue.removeLast();
            }
            queue.offer(heights[j]);
            if (i >= 0) {
                ans[i] = queue.peekFirst();
            }
        }

        return ans;
    }
}