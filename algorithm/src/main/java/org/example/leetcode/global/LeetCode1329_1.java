package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally">...</a>
 * Approach 1: Diagonal sorting with array
 */
public class LeetCode1329_1 {

    /**
     * Sort matrix diagonally using array-based approach
     * Time Complexity: O(m * n * log(min(m,n)))
     * - m: number of rows
     * - n: number of columns
     * - For each diagonal, we sort its elements
     * <p>
     * Space Complexity: O(min(m,n))
     * - Temporary array to store diagonal elements for sorting
     */
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] a = new int[Math.min(m, n)];
        for (int k = 1 - n; k < m; k++) { // k = i - j
            int leftI = Math.max(k, 0);
            int rightI = Math.min(k + n, m);
            for (int i = leftI; i < rightI; i++) {
                a[i - leftI] = mat[i][i - k];
            }
            Arrays.sort(a, 0, rightI - leftI);
            for (int i = leftI; i < rightI; i++) {
                mat[i][i - k] = a[i - leftI];
            }
        }
        return mat;
    }
}