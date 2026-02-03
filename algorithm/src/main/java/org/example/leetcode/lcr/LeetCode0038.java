package org.example.leetcode.lcr;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/iIQa4I">LeetCode LCR 038: Daily Temperatures</a>
 * <p>
 * Approach: Monotonic stack of indices. <br>
 - Maintain decreasing temperatures. <br>
 - Resolve waits when a warmer day appears.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of days; each index pushed/popped once. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and result array. <br>
 */
public class LeetCode0038 {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
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
