package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets">LeetCode 2073: Time Needed to Buy Tickets</a>
 * <p>
 * Approach: Single pass with capped contributions. <br>
 * - Sum min(tickets[i], tickets[k]) for i <= k. <br>
 * - Sum min(tickets[i], tickets[k]-1) for i > k.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; single pass.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode2073_1 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        int tk = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            totalTime += Math.min(tickets[i], i <= k ? tk : tk - 1);
        }
        return totalTime;
    }
}
