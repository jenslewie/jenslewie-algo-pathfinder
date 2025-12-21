package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/rotate-image/description/
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
