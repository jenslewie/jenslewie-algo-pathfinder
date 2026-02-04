package org.example.leetcode.global;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix">LeetCode 378: Kth Smallest Element in a Sorted Matrix</a>
 * <p>
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix. <br>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element. <br>
 * You must find a solution with a memory complexity better than O(n2). <br>
 * Follow up:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Min-heap merging rows. <br>
 * - Push the first element of each row with its coordinates. <br>
 * - Pop k times, pushing the next element in the same row.
 * <p>
 * Time Complexity: O(k * log(n)) <br>
 * - n: number of rows; heap size at most n.
 * <p>
 * Space Complexity: O(n) <br>
 * - Heap stores one element per row.
 */
public class LeetCode0378 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

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
