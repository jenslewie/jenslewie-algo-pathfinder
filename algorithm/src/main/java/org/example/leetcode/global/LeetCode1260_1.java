package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">LeetCode 1260: Shift 2D Grid</a>
 * <p>
 * Approach: Flatten, shift, and rebuild. <br>
 - Convert grid to 1D, shift by k, then map back.
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: grid dimensions.
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Extra list for flattening.
 */
public class LeetCode1260_1 {

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