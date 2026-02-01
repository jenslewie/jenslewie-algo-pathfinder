package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets">...</a>
 * Alternative approach using conditional checks
 */
public class LeetCode2073_2 {

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
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] < tickets[k]) {
                totalTime += tickets[i];
            } else {
                if (i <= k) {
                    totalTime += tickets[k];
                } else {
                    totalTime += tickets[k] - 1;
                }
            }
        }
        return totalTime;
    }
}