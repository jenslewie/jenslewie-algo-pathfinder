package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/number-of-visible-people-in-a-queue">LeetCode 1944: Number of Visible People in a Queue</a>
 * <p>
 * There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an array heights of distinct integers where heights[i] represents the height of the ith person. <br>
 * A person can see another person to their right in the queue if everybody in between is shorter than both of them. More formally, the ith person can see the jth person if i  max(heights[i+1], heights[i+2], ..., heights[j-1]). <br>
 * Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.
 * <p>
 * Difficulty: Hard
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
