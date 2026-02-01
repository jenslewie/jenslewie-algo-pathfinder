package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum">...</a>
 * Monotonic deque approach
 */
public class LeetCode0239_1 {

    /**
     * Monotonic deque approach to solve sliding window maximum problem
     * Time Complexity: O(n)
     * - n: length of the input array
     * - Each element is added and removed from the deque at most once
     * <p>
     * Space Complexity: O(k)
     * - Where k is the window size, for the deque storage
     */
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