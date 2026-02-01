package org.example.leetcode.global;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum">...</a>
 * Priority queue approach
 */
public class LeetCode0239_2 {

    /**
     * Priority queue approach to solve sliding window maximum problem
     * Time Complexity: O(n * log(k))
     * - n: length of the input array
     * - k: size of the sliding window
     * - Each element is added and removed from the priority queue once, taking O(log(k)) time
     * <p>
     * Space Complexity: O(k)
     * - Where k is the window size, for the priority queue storage
     */
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