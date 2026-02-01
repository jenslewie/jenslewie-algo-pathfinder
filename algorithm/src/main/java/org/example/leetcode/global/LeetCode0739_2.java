package org.example.leetcode.global;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures">...</a>
 * Approach 2: Monotonic stack from right to left
 */
public class LeetCode0739_2 {

    /**
     * Find daily temperatures using monotonic stack from right to left
     * Time Complexity: O(n)
     * - n: length of temperatures
     * - Each element is processed once
     * <p>
     * Space Complexity: O(n)
     * - Stack to store indices
     * - Result array of size n
     */
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