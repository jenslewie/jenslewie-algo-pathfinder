package org.example.leetcode.global;

import org.example.learning.array.DifferenceArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/car-pooling/">...</a>
 */
public class LeetCode1094 {

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

    public boolean carPooling2(int[][] trips, int capacity) {
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

    public boolean carPooling3(int[][] trips, int capacity) {
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
