package org.example.leetcode.global;

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
 * Approach: Sort by position and count fleets with max time. <br>
 - Traverse from closest to target. <br>
 - Increment fleet count when time increases.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - Sorting dominates.
 * <p>
 * Space Complexity: O(n) <br>
 * - Store pairs or times.
 */
public class LeetCode0853_3 {

    public int carFleet(int target, int[] position, int[] speed) {
        double[] times = new double[target];
        for (int i = 0; i < position.length; i++) {
            times[position[i]] = (double) (target - position[i]) / speed[i];
        }

        int ans = 0;
        double maxTime = 0;
        for (int i = times.length - 1; i >= 0; i--) {
            if (times[i] != 0 && times[i] > maxTime) {
                ans++;
                maxTime = times[i];
            }
        }
        return ans;
    }

}
