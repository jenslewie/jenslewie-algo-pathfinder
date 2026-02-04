package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum">LeetCode 239: Sliding Window Maximum</a>
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. <br>
 * Return the max sliding window.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Monotonic deque. <br>
 * - Maintain a decreasing deque of candidates. <br>
 * - The front holds the current window maximum.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is added/removed at most once.
 * <p>
 * Space Complexity: O(k) <br>
 * - k: window size for deque storage.
 */
public class LeetCode0239_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && queue.peekFirst() == nums[i - 1]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);
            if (i >= 0) {
                res[i] = queue.peekFirst();
            }
        }
        return res;
    }
}
