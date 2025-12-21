package org.example.leetcode.global;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class LeetCode0378 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {return a[0] - b[0];});

        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        while (!queue.isEmpty() && k > 0) {
            int[] temp = queue.poll();
            res = temp[0];
            int i = temp[1], j = temp[2];
            if (j + 1 < matrix[i].length) {
                queue.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
            k--;
        }

        return res;
    }

}
