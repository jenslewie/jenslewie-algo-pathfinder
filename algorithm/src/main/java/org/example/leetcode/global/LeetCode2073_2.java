package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/time-needed-to-buy-tickets">LeetCode 2073: Time Needed to Buy Tickets</a>
 * <p>
 * There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line. <br>
 * You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i]. <br>
 * Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line. <br>
 * Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.
 * <p>
 * Difficulty: Easy
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
