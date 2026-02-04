package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/car-pooling">LeetCode 1094: Car Pooling</a>
 * <p>
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west). <br>
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location. <br>
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Difference array with prefix sum. <br>
 - Mark passenger changes at start/end points. <br>
 - Accumulate to check capacity along the route.
 * <p>
 * Time Complexity: O(n + R) <br>
 * - n: trips; R: route range scanned.
 * <p>
 * Space Complexity: O(R) <br>
 * - Difference array for the route.
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