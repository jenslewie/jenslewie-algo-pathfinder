package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally">...</a>
 * Approach 2: HashMap-based approach
 */
public class LeetCode1329_2 {

    /**
     * Sort matrix diagonally using HashMap approach
     * Time Complexity: O(m * n * log(min(m,n)))
     * - m: number of rows
     * - n: number of columns
     * - For each diagonal, we sort its elements
     * <p>
     * Space Complexity: O(m * n)
     * - HashMap to store diagonal elements
     * - Each diagonal list stores its elements
     */
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