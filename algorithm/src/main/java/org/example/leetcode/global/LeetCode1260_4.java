package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">...</a>
 * Approach 4: Direct assignment approach
 */
public class LeetCode1260_4 {

    /**
     * Shift 2D grid using direct assignment approach
     * Time Complexity: O(m * n)
     * - m: number of rows
     * - n: number of columns
     * - Single pass through all elements
     * <p>
     * Space Complexity: O(m * n)
     * - Result list to store the final answer
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> results = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int ignored : row) {
                list.add(0);
            }
            results.add(list);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + k) % (m * n);
                results.get(index / n).set(index % n, grid[i][j]);
            }
        }

        return results;
    }
}