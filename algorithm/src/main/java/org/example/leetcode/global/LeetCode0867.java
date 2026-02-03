package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/transpose-matrix">LeetCode 867: Transpose Matrix</a>
 * <p>
 * Approach: Create a new matrix with swapped indices. <br>
 - result[j][i] = matrix[i][j].
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: matrix dimensions. <br>
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Output matrix. <br>
 */
public class LeetCode0867 {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] results = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                results[j][i] = matrix[i][j];
            }
        }

        return results;
    }

}
