package org.example.leetcode.lcr;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof">LCR 183: 望远镜中最高的海拔</a>
 * <p>
 * 科技馆内有一台虚拟观景望远镜，它可以用来观测特定纬度地区的地形情况。
 * 该纬度的海拔数据记于数组 heights ，其中 heights[i] 表示对应位置的海拔高度。
 * 请找出并返回望远镜视野范围 limit 内，可以观测到的最高海拔值。
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Priority queue with lazy removal. <br>
 * - Push elements with indices. <br>
 * - Pop while index is out of window.
 * <p>
 * Time Complexity: O(n * log(k)) <br>
 * - n: length of the array; heap ops are log(k).
 * <p>
 * Space Complexity: O(k) <br>
 * - Heap stores up to k elements.
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