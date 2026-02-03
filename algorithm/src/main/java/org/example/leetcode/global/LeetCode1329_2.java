package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally">LeetCode 1329: Sort the Matrix Diagonally</a>
 * <p>
 * Approach: Use priority queues per diagonal. <br>
 - Push diagonal elements into a min-heap. <br>
 - Pop to fill in sorted order.
 * <p>
 * Time Complexity: O(m * n * log(min(m, n))) <br>
 * - Heap operations for each diagonal. <br>
 * <p>
 * Space Complexity: O(m * n) <br>
 * - Heaps across diagonals. <br>
 */
public class LeetCode1329_2 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonal = i - j;
                map.putIfAbsent(diagonal, new ArrayList<>());
                map.get(diagonal).add(mat[i][j]);
            }
        }

        for (List<Integer> list : map.values()) {
            list.sort(Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = map.get(i - j);
                mat[i][j] = list.remove(list.size() - 1);
            }
        }

        return mat;
    }
}