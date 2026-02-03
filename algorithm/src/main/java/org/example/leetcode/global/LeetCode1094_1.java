package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/car-pooling">LeetCode 1094: Car Pooling</a>
 * <p>
 * Approach: Difference array with prefix sum. <br>
 - Mark passenger changes at start/end points. <br>
 - Accumulate to check capacity along the route.
 * <p>
 * Time Complexity: O(n + R) <br>
 * - n: trips; R: route range scanned. <br>
 * <p>
 * Space Complexity: O(R) <br>
 * - Difference array for the route. <br>
 */
public class LeetCode1094_1 {

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