package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii">LeetCode 59: Spiral Matrix II</a>
 * <p>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Boundary simulation with incremental fill. <br>
 * - Maintain top, bottom, left, and right bounds. <br>
 * - Fill numbers along the edges while shrinking bounds.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: matrix dimension; each cell is filled once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Output matrix excluded; constant extra space.
 */
public class LeetCode0059 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int upper = 0, lower = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (upper <= lower) {
            for (int j = left; j <= right; j++) {
                result[upper][j] = num++;
            }
            upper++;

            for (int i = upper; i <= lower; i++) {
                result[i][right] = num++;
            }
            right--;

            if (upper <= lower) {
                for (int j = right; j >= left; j--) {
                    result[lower][j] = num++;
                }
                lower--;
            }

            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }

}
