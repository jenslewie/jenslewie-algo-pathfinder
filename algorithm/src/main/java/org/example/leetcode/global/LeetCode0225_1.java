package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues">...</a>
 * Single queue approach to implement stack
 */
public class LeetCode0225_1 {

    private final Queue<Integer> mainQueue;
    private int size;

    public LeetCode0225_1() {
        mainQueue = new ArrayDeque<>();
        size = 0;
    }

    /**
     * Push operation using single queue approach
     * Time Complexity: O(n)
     * - n: current size of the stack
     * - We rotate all existing elements to place the new element at front
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space for rotation
     */
    public void push(int x) {
        mainQueue.offer(x);
        for (int i = 0; i < size; i++) {
            mainQueue.offer(mainQueue.poll());
        }
        size++;
    }

    /**
     * Pop operation using single queue approach
     * Time Complexity: O(1)
     * - Direct removal from front of queue
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public int pop() {
        if (!mainQueue.isEmpty()) {
            size--;
            return mainQueue.poll();
        }
        return -1;
    }

    /**
     * Top operation using single queue approach
     * Time Complexity: O(1)
     * - Direct access to front of queue
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public int top() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.peek();
        }
        return -1;
    }

    /**
     * Empty check using single queue approach
     * Time Complexity: O(1)
     * - Direct check of queue emptiness
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}