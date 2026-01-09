package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets">...</a>
 */
public class LeetCode2073 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        int tk = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            totalTime += Math.min(tickets[i], i <= k ? tk : tk - 1);
        }
        return totalTime;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
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
