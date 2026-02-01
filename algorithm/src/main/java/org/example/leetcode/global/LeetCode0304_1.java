package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable">...</a>
 * Prefix sum approach
 */
public class LeetCode0304_1 {

    private final int[][] preSum;

    /**
     * version 1:
     * 0  0  0  0  0  0
     * 3 0 1 4 2         0  3  3  4  8 10
     * 5 6 3 2 1 =====>  0  8 14 18 24 27
     * 1 2 0 1 5         0  9 17 21 28 36
     * 4 1 0 1 7         0 13 22 26 34 49
     * 1 0 3 0 5         0 14 23 30 38 58
     *
     * @param matrix
     */
    public LeetCode0304_1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    /**
     * Range sum query using 2D prefix sum
     * Time Complexity: O(1)
     * - Each query takes constant time
     * <p>
     * Space Complexity: O(m*n)
     * - Where m and n are dimensions of the matrix
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}