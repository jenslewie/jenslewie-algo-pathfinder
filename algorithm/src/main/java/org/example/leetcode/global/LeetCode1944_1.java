package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue">LeetCode 1944: Number of Visible People in a Queue</a>
 * <p>
 * Approach: Monotonic stack from right to left. <br>
 * - Pop shorter people while counting visibility. <br>
 * - If a taller person remains, they are also visible.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of people; each height is pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores heights.
 */
public class LeetCode1944_1 {

    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }
            ans[i] = stack.isEmpty() ? count : count + 1;
            stack.push(heights[i]);
        }
        return ans;
    }

}
