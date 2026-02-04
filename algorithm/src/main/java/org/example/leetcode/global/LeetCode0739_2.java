package org.example.leetcode.global;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures">LeetCode 739: Daily Temperatures</a>
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Monotonic stack from right to left. <br>
 * - Pop non-warmer days to find the next warmer day index. <br>
 * - Compute distance to the next warmer day.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of days; each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and result array.
 */
public class LeetCode0739_2 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
