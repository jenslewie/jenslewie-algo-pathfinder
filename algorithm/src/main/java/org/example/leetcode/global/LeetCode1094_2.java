package org.example.leetcode.global;

import org.example.learning.array.DifferenceArray;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/car-pooling">LeetCode 1094: Car Pooling</a>
 * <p>
 * Approach: Sorting events. <br>
 - Convert trips into pickup/drop-off events. <br>
 - Sweep in order to track capacity.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - n: number of trips; sorting events dominates. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Event list. <br>
 */
public class LeetCode1094_2 {

    /**
     * Difference array with utility class approach to solve car pooling problem
     * Time Complexity: O(n + m)
     * - n: number of trips
     * - m: max position value
     * - We iterate through trips once to populate difference array, then once through positions
     * <p>
     * Space Complexity: O(m)
     * - Where m is the max position value for the difference array
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }

        int[] nums = new int[toMax + 1];
        DifferenceArray differenceArray = new DifferenceArray(nums);
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2] - 1;
            differenceArray.increment(from, to, numPassengers);
        }

        return Arrays.stream(differenceArray.result()).noneMatch(result -> result > capacity);
    }
}