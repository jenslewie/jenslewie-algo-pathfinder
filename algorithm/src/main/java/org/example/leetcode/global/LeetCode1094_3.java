package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/car-pooling">LeetCode 1094: Car Pooling</a>
 * <p>
 * Approach: Priority queue over destinations. <br>
 - Sort trips by start time and release passengers by earliest end. <br>
 - Track current load.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - Sorting and heap operations.
 * <p>
 * Space Complexity: O(n) <br>
 * - Heap stores active trips.
 */
public class LeetCode1094_3 {

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