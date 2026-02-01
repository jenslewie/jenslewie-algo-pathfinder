package org.example.leetcode.global;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures">...</a>
 * Approach 1: Monotonic stack from left to right
 */
public class LeetCode0739_1 {

    /**
     * Find daily temperatures using monotonic stack from left to right
     * Time Complexity: O(n)
     * - n: length of temperatures
     * - Each element is pushed and popped at most once from the stack
     * <p>
     * Space Complexity: O(n)
     * - Stack to store indices
     * - Result array of size n
     */
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