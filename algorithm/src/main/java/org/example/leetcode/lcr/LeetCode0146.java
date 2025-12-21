package org.example.leetcode.lcr;

/**
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/
 */
public class LeetCode0146 {

    public int[] spiralArray(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[]{};
        }
        int m = array.length, n = array[0].length;
        int[] results = new int[m * n];
        int upper = 0, lower = m - 1, left = 0, right = n - 1;
        int num = 0;

        while (num < m * n) {
            if (upper <= lower) {
                for (int j = left; j <= right; j++) {
                    results[num++] = array[upper][j];
                }
                upper++;
            }
            if (left <= right) {
                for (int i = upper; i <= lower; i++) {
                    results[num++] = array[i][right];
                }
                right--;
            }
            if (upper <= lower) {
                for (int j = right; j >= left; j--) {
                    results[num++] = array[lower][j];
                }
                lower--;
            }
            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    results[num++] = array[i][left];
                }
                left++;
            }
        }
        return results;
    }

}
