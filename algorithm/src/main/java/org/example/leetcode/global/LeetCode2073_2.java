package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets">LeetCode 2073: Time Needed to Buy Tickets</a>
 * <p>
 * Approach: Conditional accumulation. <br>
 * - For each person, add tickets[i] if less than tickets[k]. <br>
 * - Otherwise add tickets[k] or tickets[k]-1 depending on position.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; single pass.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode2073_2 {

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
