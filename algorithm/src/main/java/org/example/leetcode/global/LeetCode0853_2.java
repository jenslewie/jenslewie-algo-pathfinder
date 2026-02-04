package org.example.leetcode.global;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/car-fleet">LeetCode 853: Car Fleet</a>
 * <p>
 * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target. <br>
 * You are given two integer arrays position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour. <br>
 * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car. <br>
 * A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet. <br>
 * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet. <br>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * Difficulty: Medium
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
