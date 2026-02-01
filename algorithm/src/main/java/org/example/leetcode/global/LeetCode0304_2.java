package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable">...</a>
 * Row-wise prefix sum approach
 */
public class LeetCode0304_2 {

    private final int[][] preSum;

    /**
     * version 2:
     * 3 0 1 4 2        0  3  3  4  8 10
     * 5 6 3 2 1        0  5  6 14 16 17
     * 1 2 0 1 5 =====> 0  1  3  3  4  9
     * 4 1 0 1 7        0  4  5  5  6 13
     * 1 0 3 0 5        0  1  1  4  4  9
     *
     * @param matrix
     */
    public LeetCode0304_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i][j + 1] = preSum[i][j] + matrix[i][j];
            }
        }
    }

    /**
     * Range sum query using row-wise prefix sum
     * Time Complexity: O(row2 - row1 + 1)
     * - Need to iterate through rows to calculate sum
     * <p>
     * Space Complexity: O(m*n)
     * - Where m and n are dimensions of the matrix
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += preSum[i][col2 + 1] - preSum[i][col1];
        }
        return result;
    }
}