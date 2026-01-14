package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/car-fleet">...</a>
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
