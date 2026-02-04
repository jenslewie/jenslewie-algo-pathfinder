package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues">LeetCode 225: Implement Stack using Queues</a>
 * <p>
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty). <br>
 * Implement the MyStack class: <br>
 * Notes: <br>
 * Follow-up: Can you implement the stack using only one queue?
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Single queue rotation. <br>
 * - Push by rotating the queue to place the new element at the front. <br>
 * - Pop/top read directly from the front.
 * <p>
 * Time Complexity: O(n) for push, O(1) for pop/top/empty <br>
 * - n: current stack size; rotation costs linear time on push.
 * <p>
 * Space Complexity: O(n) <br>
 * - Queue stores all elements.
 */
public class LeetCode0225_1 {

    private final Queue<Integer> mainQueue;
    private int size;

    public LeetCode0225_1() {
        mainQueue = new ArrayDeque<>();
        size = 0;
    }

    public void push(int x) {
        mainQueue.offer(x);
        for (int i = 0; i < size; i++) {
            mainQueue.offer(mainQueue.poll());
        }
        size++;
    }

    public int pop() {
        if (!mainQueue.isEmpty()) {
            size--;
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
