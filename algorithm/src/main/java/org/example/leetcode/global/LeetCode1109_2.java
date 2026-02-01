package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/corporate-flight-bookings">...</a>
 * Approach 2: Difference array with separate computation
 */
public class LeetCode1109_2 {

    /**
     * Calculate flight bookings using difference array with separate computation
     * Time Complexity: O(m + n)
     * - m: length of bookings
     * - n: number of flights
     * - Single pass through bookings + single pass to compute prefix sums
     * <p>
     * Space Complexity: O(n)
     * - Difference array of size n
     * - Result array of size n
     */
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