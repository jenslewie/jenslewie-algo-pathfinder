package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-the-matrix-diagonally">LeetCode 1329: Sort the Matrix Diagonally</a>
 * <p>
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2]. <br>
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sort each diagonal with a list. <br>
 - Collect elements of each diagonal, sort, and write back.
 * <p>
 * Time Complexity: O(m * n log(min(m, n))) <br>
 * - Sorting each diagonal dominates.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - Temporary list for a diagonal.
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