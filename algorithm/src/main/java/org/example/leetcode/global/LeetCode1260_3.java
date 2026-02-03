package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shift-2d-grid">LeetCode 1260: Shift 2D Grid</a>
 * <p>
 * Approach: Deque rotation. <br>
 - Insert all elements into a deque. <br>
 - Rotate by k and rebuild grid.
 * <p>
 * Time Complexity: O(m * n) <br>
 * - m, n: grid dimensions. <br>
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Deque stores all elements. <br>
 */
public class LeetCode1260_3 {

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