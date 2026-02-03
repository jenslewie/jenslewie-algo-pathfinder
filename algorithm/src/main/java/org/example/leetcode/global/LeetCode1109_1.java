package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/corporate-flight-bookings">LeetCode 1109: Corporate Flight Bookings</a>
 * <p>
 * Approach: Difference array with prefix sum. <br>
 - Apply seat deltas to start/end+1 indices. <br>
 - Prefix sum yields final bookings.
 * <p>
 * Time Complexity: O(n + m) <br>
 * - n: flights; m: bookings. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Difference array. <br>
 */
public class LeetCode1109_1 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}