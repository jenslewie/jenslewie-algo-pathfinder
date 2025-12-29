package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/corporate-flight-bookings">...</a>
 */
public class LeetCode1109 {

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

    public int[] corpFlightBookings2(int[][] bookings, int n) {
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
