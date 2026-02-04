package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/car-fleet">LeetCode 853: Car Fleet</a>
 * <p>
 * Approach: Monotonic stack of times after sorting by position. <br>
 - Push times in descending position order. <br>
 - Pop when a car catches up to form a fleet.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - Sorting dominates.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack of times.
 */
public class LeetCode0853_2 {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (c1, c2) -> c2.position - c1.position);

        double[] times = new double[n];
        for (int i = 0; i < cars.length; i++) {
            times[i] = cars[i].time;
        }

        int ans = 0;
        double maxTime = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] > maxTime) {
                maxTime = times[i];
                ans++;
            }
        }
        return ans;
    }

    static class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

}
