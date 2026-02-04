package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable">LeetCode 304: Range Sum Query 2D - Immutable</a>
 * <p>
 * Given a 2D matrix matrix, handle multiple queries of the following type: <br>
 * Implement the NumMatrix class: <br>
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Row-wise prefix sums. <br>
 * - Precompute prefix sums for each row. <br>
 * - Sum over rows within [row1, row2] for each query.
 * <p>
 * Time Complexity: O(m * n) build, O(row2 - row1 + 1) per query <br>
 * - m, n: matrix dimensions.
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Row-wise prefix sum matrix.
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

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += preSum[i][col2 + 1] - preSum[i][col1];
        }
        return result;
    }
}
