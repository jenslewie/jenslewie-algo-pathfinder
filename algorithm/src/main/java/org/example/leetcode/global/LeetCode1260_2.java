package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">LeetCode 1260: Shift 2D Grid</a>
 * <p>
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times. <br>
 * In one shift operation: <br>
 * Return the 2D grid after applying shift operation k times.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Index mapping without full flatten. <br>
 - Compute new index for each cell after shift. <br>
 - Fill a new grid accordingly.
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: grid dimensions.
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Output grid.
 */
public class LeetCode1260_2 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = m * n;
        k = k % mn;

        reverse(grid, mn - k, mn - 1);
        reverse(grid, 0, mn - k - 1);
        reverse(grid, 0, mn - 1);
        return convertArrayToList(grid);
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

    private int get(int[][] grid, int index) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        return grid[i][j];
    }

    private void set(int[][] grid, int index, int value) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        grid[i][j] = value;
    }

    private void reverse(int[][] grid, int i, int j) {
        while (i < j) {
            int temp = get(grid, i);
            set(grid, i, get(grid, j));
            set(grid, j, temp);
            i++;
            j--;
        }
    }
}