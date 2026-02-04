package org.example.leetcode.global;

import org.example.learning.array.DifferenceArray;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/car-pooling">LeetCode 1094: Car Pooling</a>
 * <p>
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west). <br>
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location. <br>
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sorting events. <br>
 - Convert trips into pickup/drop-off events. <br>
 - Sweep in order to track capacity.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - n: number of trips; sorting events dominates.
 * <p>
 * Space Complexity: O(n) <br>
 * - Event list.
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