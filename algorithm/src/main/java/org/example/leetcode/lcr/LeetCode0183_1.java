package org.example.leetcode.lcr;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof">LeetCode LCR 183: Sliding Window Maximum</a>
 * <p>
 * Approach: Monotonic deque. <br>
 - Maintain decreasing deque of candidates. <br>
 - The front is the current maximum.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element pushed/popped once.
 * <p>
 * Space Complexity: O(k) <br>
 * - k: window size.
 */
public class LeetCode0183_1 {

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