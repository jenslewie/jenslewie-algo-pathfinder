package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/corporate-flight-bookings">...</a>
 * Approach 1: Difference array with prefix sum
 */
public class LeetCode1109_1 {

    /**
     * Calculate flight bookings using difference array with prefix sum
     * Time Complexity: O(m + n)
     * - m: length of bookings
     * - n: number of flights
     * - Single pass through bookings + single pass to compute prefix sums
     * <p>
     * Space Complexity: O(1)
     * - Only using the result array of size n
     */
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