package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/online-stock-span">LeetCode 901: Online Stock Span</a>
 * <p>
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day. <br>
 * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day. <br>
 * Implement the StockSpanner class:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Monotonic stack of (price, span). <br>
 - Pop while price is higher to accumulate span. <br>
 - Push the current price and span.
 * <p>
 * Time Complexity: O(1) amortized <br>
 * - Each price is pushed and popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores past prices.
 */
public class LeetCode0901_1 {

    private final Deque<int[]> stack;

    public LeetCode0901_1() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] prev = stack.pop();
            count += prev[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }

}
