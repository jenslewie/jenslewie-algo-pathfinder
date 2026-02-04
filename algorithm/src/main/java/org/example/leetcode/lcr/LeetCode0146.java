package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/">LeetCode LCR 146: Spiral Order of Matrix</a>
 * <p>
 * Approach: Boundary simulation. <br>
 - Maintain top/bottom/left/right bounds. <br>
 - Traverse edges while shrinking bounds.
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: matrix dimensions; each element visited once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Output array excluded.
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

        while (upper <= lower && left <= right) {
            for (int j = left; j <= right; j++) {
                results[num++] = array[upper][j];
            }
            upper++;

            for (int i = upper; i <= lower; i++) {
                results[num++] = array[i][right];
            }
            right--;

            if (upper > lower || left > right) {
                break;
            }

            for (int j = right; j >= left; j--) {
                results[num++] = array[lower][j];
            }
            lower--;

            for (int i = lower; i >= upper; i--) {
                results[num++] = array[i][left];
            }
            left++;
        }
        return results;
    }

}
