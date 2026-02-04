package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/number-of-recent-calls">LeetCode 933: Number of Recent Calls</a>
 * <p>
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame. <br>
 * Implement the RecentCounter class: <br>
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Queue of timestamps. <br>
 - Push current time; pop times older than t-3000. <br>
 - Queue size is the answer.
 * <p>
 * Time Complexity: O(1) amortized <br>
 * - Each time is enqueued and dequeued once.
 * <p>
 * Space Complexity: O(w) <br>
 * - w: number of calls within the last 3000 ms.
 */
public class LeetCode0933 {

    static final int TIME = 3000;
    Queue<Integer> queue;

    public LeetCode0933() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - TIME) {
            queue.poll();
        }
        return queue.size();
    }

}
