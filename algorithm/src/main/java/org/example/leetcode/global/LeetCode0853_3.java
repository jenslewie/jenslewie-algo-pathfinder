package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/car-fleet">LeetCode 853: Car Fleet</a>
 * <p>
 * Approach: Sort by position and count fleets with max time. <br>
 - Traverse from closest to target. <br>
 - Increment fleet count when time increases.
 * <p>
 * Time Complexity: O(n * log(n)) <br>
 * - Sorting dominates. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Store pairs or times. <br>
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
