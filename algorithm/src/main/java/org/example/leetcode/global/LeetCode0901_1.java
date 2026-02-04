package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/online-stock-span">LeetCode 901: Online Stock Span</a>
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
