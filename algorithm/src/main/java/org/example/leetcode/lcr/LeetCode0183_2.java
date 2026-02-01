package org.example.leetcode.lcr;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof">...</a>
 * Priority queue approach
 */
public class LeetCode0183_2 {

    /**
     * Priority queue approach to find maximum altitude in sliding window
     * Time Complexity: O(n*log(k))
     * - n: length of the input array
     * - k: window size
     * - Each element is added and removed from the priority queue
     * <p>
     * Space Complexity: O(k)
     * - Where k is the window size, for storing elements in the priority queue
     */
    public int[] maxAltitude(int[] heights, int limit) {
        int n = heights.length;
        if (n == 0 || limit == 0) {
            return new int[0];
        }

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        int[] ans = new int[n - limit + 1];

        for (int i = 0; i < limit; i++) {
            queue.offer(new int[]{heights[i], i});
        }
        ans[0] = queue.peek()[0];

        for (int i = limit; i < n; i++) {
            queue.offer(new int[]{heights[i], i});
            while (queue.peek()[1] <= i - limit) {
                queue.poll();
            }
            ans[i - limit + 1] = queue.peek()[0];
        }

        return ans;
    }
}