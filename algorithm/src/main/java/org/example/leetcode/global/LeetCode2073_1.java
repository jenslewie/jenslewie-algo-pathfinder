package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets">...</a>
 * Optimized approach using mathematical calculation
 */
public class LeetCode2073_1 {

    /**
     * Calculate time needed for person at position k to buy all tickets
     * Time Complexity: O(n)
     * - n: length of tickets array
     * - Single pass through the array
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for variables
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        int tk = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            totalTime += Math.min(tickets[i], i <= k ? tk : tk - 1);
        }
        return totalTime;
    }
}