package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/car-fleet">LeetCode 853: Car Fleet</a>
 * <p>
 * Approach: Sort by position descending and track max arrival time. <br>
 - Compute time to target for each car. <br>
 - Count a new fleet when time exceeds current max.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - n: number of cars; sorting dominates.
 * <p>
 * Space Complexity: O(n) <br>
 * - Store pairs of position/time.
 */
public class LeetCode0853_1 {

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

        Deque<Double> queue = new ArrayDeque<>();
        for (int i = times.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && queue.peek() <= times[i]) {
                queue.pop();
            }
            queue.push(times[i]);
        }

        return queue.size();
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
