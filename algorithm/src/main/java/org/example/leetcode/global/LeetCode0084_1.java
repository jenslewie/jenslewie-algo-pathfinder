package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram">LeetCode 84: Largest Rectangle in Histogram</a>
 * <p>
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Monotonic stack with left/right bounds. <br>
 * - For each bar, compute nearest smaller to left and right. <br>
 * - Max area is height * (right - left - 1).
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of bars; each index is pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and boundary arrays.
 */
public class LeetCode0084_1 {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

}
