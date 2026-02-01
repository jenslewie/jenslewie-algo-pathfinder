package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/car-pooling/">...</a>
 * Brute force map approach
 */
public class LeetCode1094_3 {

    /**
     * Brute force map approach to solve car pooling problem
     * Time Complexity: O(n * m)
     * - n: number of trips
     * - m: average trip distance
     * - For each trip, we iterate through the route segment
     * <p>
     * Space Complexity: O(m)
     * - Where m is the max position value stored in the map
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            for (int i = from; i < to; i++) {
                map.put(i, map.getOrDefault(i, 0) + numPassengers);
            }
        }

        return map.values().stream().noneMatch(v -> v > capacity);
    }
}