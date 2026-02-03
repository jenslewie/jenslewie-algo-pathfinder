package org.example.leetcode.global;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures">LeetCode 739: Daily Temperatures</a>
 * <p>
 * Approach: Monotonic stack from left to right. <br>
 * - Store indices of decreasing temperatures. <br>
 * - When a warmer day appears, resolve pending indices.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of days; each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and result array.
 */
public class LeetCode0739_1 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
