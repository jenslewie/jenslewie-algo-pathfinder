package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">...</a>
 * Approach 3: Array flattening approach
 */
public class LeetCode1260_3 {

    /**
     * Shift 2D grid using array flattening approach
     * Time Complexity: O(m * n)
     * - m: number of rows
     * - n: number of columns
     * - Single pass through all elements
     * <p>
     * Space Complexity: O(m * n)
     * - Temporary array to store flattened grid
     * - Result list to store the final answer
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);

        int count = 0;
        int[] reverse = new int[k];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (count < k) {
                    reverse[count++] = grid[i][j];
                } else {
                    break;
                }
            }
        }

        int[] temp = new int[m * n];
        count = 0;
        for (int i = k - 1; i >= 0; i--) {
            temp[count++] = reverse[i];
        }

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (count < m * n) {
                    temp[count++] = ints[j];
                } else {
                    break;
                }
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            results.add(new ArrayList<>());
        }

        for (int i = 0; i < m * n; i++) {
            results.get(i / n).add(temp[i]);
        }

        return results;
    }
}