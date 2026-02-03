package org.example.leetcode.lcr;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof">LeetCode LCR 183: Sliding Window Maximum</a>
 * <p>
 * Approach: Priority queue with lazy removal. <br>
 - Push elements with indices. <br>
 - Pop while index is out of window.
 * <p>
 * Time Complexity: O(n * log(k)) <br>
 * - n: length of the array; heap ops are log(k). <br>
 * <p>
 * Space Complexity: O(k) <br>
 * - Heap stores up to k elements. <br>
 */
public class LeetCode0183_2 {

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