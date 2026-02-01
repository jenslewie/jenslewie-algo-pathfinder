package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">...</a>
 * Approach 1: Direct index mapping
 */
public class LeetCode1260_1 {

    /**
     * Shift 2D grid using direct index mapping
     * Time Complexity: O(m * n)
     * - m: number of rows
     * - n: number of columns
     * - Single pass through all elements
     * <p>
     * Space Complexity: O(m * n)
     * - Temporary 2D array to store shifted values
     * - Result list to store the final answer
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + k) % (m * n);
                temp[index / n][index % n] = grid[i][j];
            }
        }
        return convertArrayToList(temp);
    }

    private List<List<Integer>> convertArrayToList(int[][] arr) {
        List<List<Integer>> results = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> list = new ArrayList<>();
            for (int i : row) {
                list.add(i);
            }
            results.add(list);
        }
        return results;
    }
}