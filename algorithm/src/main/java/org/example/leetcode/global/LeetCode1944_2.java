package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue">LeetCode 1944: Number of Visible People in a Queue</a>
 * <p>
 * There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an array heights of distinct integers where heights[i] represents the height of the ith person. <br>
 * A person can see another person to their right in the queue if everybody in between is shorter than both of them. More formally, the ith person can see the jth person if i  max(heights[i+1], heights[i+2], ..., heights[j-1]). <br>
 * Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.
 * <p>
 * Difficulty: Hard
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
