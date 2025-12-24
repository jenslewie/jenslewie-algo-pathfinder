package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">...</a>
 */
public class LeetCode1260 {

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

    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = m * n;
        k = k % mn;

        reverse(grid, mn - k, mn - 1);
        reverse(grid, 0, mn - k - 1);
        reverse(grid, 0, mn - 1);
        return convertArrayToList(grid);
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

    public List<List<Integer>> shiftGrid3(int[][] grid, int k) {
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

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count < m * n) {
                    temp[count++] = grid[i][j];
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

    public List<List<Integer>> shiftGrid4(int[][] grid, int k) {
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
