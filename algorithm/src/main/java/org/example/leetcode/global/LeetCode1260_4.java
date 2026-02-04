package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/shift-2d-grid">LeetCode 1260: Shift 2D Grid</a>
 * <p>
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times. <br>
 * In one shift operation: <br>
 * Return the 2D grid after applying shift operation k times.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Modular index shift. <br>
 - Treat grid as circular 1D and compute shifted index. <br>
 - Map back to 2D coordinates.
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: grid dimensions.
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Output grid.
 */
public class LeetCode1260_4 {

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