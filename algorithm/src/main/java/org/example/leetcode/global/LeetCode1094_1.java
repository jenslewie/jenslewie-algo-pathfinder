package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/car-pooling/">...</a>
 * Difference array approach
 */
public class LeetCode1094_1 {

    /**
     * Difference array approach to solve car pooling problem
     * Time Complexity: O(n + m)
     * - n: number of trips
     * - m: max position value
     * - We iterate through trips once to build difference array, then once through positions
     * <p>
     * Space Complexity: O(m)
     * - Where m is the max position value for the difference array
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }

        int[] diff = new int[toMax + 1];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int count = 0;
        for (int i = 0; i <= toMax; i++) {
            count += diff[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}