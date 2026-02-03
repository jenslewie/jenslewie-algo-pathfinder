package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/description/
 */
public class LeetCode0054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper = 0, lower = m - 1, left = 0, right = n - 1;
        List<Integer> result = new ArrayList<>();
        while (upper <= lower && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[upper][j]);
            }
            upper++;

            for (int i = upper; i <= lower; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (upper <= lower) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[lower][j]);
                }
                lower--;
            }

            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

}
