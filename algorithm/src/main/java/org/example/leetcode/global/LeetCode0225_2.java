package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues">LeetCode 225: Implement Stack using Queues</a>
 * <p>
 * Approach: Dual queues with reordering. <br>
 * - Push by moving all elements behind the new one. <br>
 * - Pop/top read directly from the front.
 * <p>
 * Time Complexity: O(n) for push, O(1) for pop/top/empty <br>
 * - n: current stack size; moving elements costs linear time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queues store all elements.
 */
public class LeetCode0225_2 {

    private Queue<Integer> mainQueue, tempQueue;

    public LeetCode0225_2() {
        mainQueue = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        tempQueue.offer(x);
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }
        mainQueue = tempQueue;
        tempQueue = new ArrayDeque<>();
    }

    public int pop() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.poll();
        }
        return -1;
    }

    public int top() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.peek();
        }
        return -1;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
