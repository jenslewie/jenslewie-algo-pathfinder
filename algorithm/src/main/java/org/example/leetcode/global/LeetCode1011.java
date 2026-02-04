package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days">LeetCode 1011: Capacity To Ship Packages Within D Days</a>
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within days days. <br>
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship. <br>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Binary search on capacity. <br>
 * - Check how many days needed for a candidate capacity. <br>
 * - Shrink the search range.
 * <p>
 * Time Complexity: O(n * log(W)) <br>
 * - n: number of packages; W: sum of weights.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode1011 {

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int weight : weights) {
            low = Math.max(weight, low);
            high += weight;
        }

        while (low < high) {
            int capacity = low + (high - low) / 2;
            if (days >= getDays(weights, capacity)) {
                high = capacity;
            } else {
                low = capacity + 1;
            }
        }

        return low;
    }

    private int getDays(int[] weights, int capacity) {
        int days = 0;
        int temp = 0;
        for (int weight : weights) {
            if (temp + weight > capacity) {
                days++;
                temp = weight;
            } else {
                temp += weight;
            }
        }
        return days + 1;
    }

}
