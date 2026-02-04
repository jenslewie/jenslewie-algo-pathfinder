package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/transpose-matrix">LeetCode 867: Transpose Matrix</a>
 * <p>
 * Given a 2D integer array matrix, return the transpose of matrix. <br>
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Create a new matrix with swapped indices. <br>
 - result[j][i] = matrix[i][j].
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: matrix dimensions.
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Output matrix.
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
