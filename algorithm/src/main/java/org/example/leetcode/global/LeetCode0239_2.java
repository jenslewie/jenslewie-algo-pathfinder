package org.example.leetcode.global;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum">LeetCode 239: Sliding Window Maximum</a>
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. <br>
 * Return the max sliding window.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Max-heap (priority queue). <br>
 * - Push values with indices; remove elements that fall out of the window. <br>
 * - The heap top is the current maximum.
 * <p>
 * Time Complexity: O(n * log(k)) <br>
 * - n: length of the array; each push/pop is log(k).
 * <p>
 * Space Complexity: O(k) <br>
 * - Heap stores at most k elements.
 */
public class LeetCode0239_2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];

        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }

        return ans;
    }
}
