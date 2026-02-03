package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
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
