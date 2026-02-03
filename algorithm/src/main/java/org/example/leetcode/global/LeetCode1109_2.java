package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/corporate-flight-bookings">LeetCode 1109: Corporate Flight Bookings</a>
 * <p>
 * Approach: Difference array (alternative). <br>
 - Same idea with a separate delta array. <br>
 - Prefix sum computes results.
 * <p>
 * Time Complexity: O(n + m) <br>
 * - n: flights; m: bookings. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Difference array. <br>
 */
public class LeetCode1109_2 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                diff[booking[1]] -= booking[2];
            }
        }

        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }

        return ans;
    }
}