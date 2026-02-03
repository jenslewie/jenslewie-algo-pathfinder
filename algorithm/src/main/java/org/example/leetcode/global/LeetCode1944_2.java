package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue">LeetCode 1944: Number of Visible People in a Queue</a>
 * <p>
 * Approach: Monotonic stack from left to right. <br>
 * - Pop shorter people and increment their visibility count. <br>
 * - The current top (if any) also sees this person.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of people; each index is pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores indices.
 */
public class LeetCode1944_2 {

    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                ans[stack.pop()]++;
            }
            if (!stack.isEmpty()) {
                ans[stack.peek()]++;
            }
            stack.push(i);
        }
        return ans;
    }

}
