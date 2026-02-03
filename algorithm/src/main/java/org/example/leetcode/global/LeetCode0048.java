package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/rotate-image">LeetCode 48: Rotate Image</a>
 * <p>
 * Approach: Transpose then reverse each row. <br>
 * - Transpose the matrix across its main diagonal. <br>
 * - Reverse each row to achieve a 90-degree clockwise rotation.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: dimension of the n x n matrix; each element is visited once in each step.
 * <p>
 * Space Complexity: O(1) <br>
 * - Rotation is done in-place.
 */
public class LeetCode0048 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose matrix along main diagonal (top-left to bottom-right)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int[] row : matrix) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = row[left];
                row[left++] = row[right];
                row[right--] = temp;
            }
        }
    }

}
