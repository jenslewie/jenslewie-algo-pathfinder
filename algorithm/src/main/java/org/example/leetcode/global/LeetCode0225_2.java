package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues">...</a>
 * Dual queue approach to implement stack
 */
public class LeetCode0225_2 {

    private Queue<Integer> mainQueue, tempQueue;

    public LeetCode0225_2() {
        mainQueue = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
    }

    /**
     * Push operation using dual queue approach
     * Time Complexity: O(n)
     * - n: current size of the stack
     * - We move all elements to temp queue, add new element, then move back
     * <p>
     * Space Complexity: O(1)
     * - Only using the second queue as temporary storage
     */
    public void push(int x) {
        tempQueue.offer(x);
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }
        mainQueue = tempQueue;
        tempQueue = new ArrayDeque<>();
    }

    /**
     * Pop operation using dual queue approach
     * Time Complexity: O(1)
     * - Direct removal from front of main queue
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public int pop() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.poll();
        }
        return -1;
    }

    /**
     * Top operation using dual queue approach
     * Time Complexity: O(1)
     * - Direct access to front of main queue
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
     * Empty check using dual queue approach
     * Time Complexity: O(1)
     * - Direct check of main queue emptiness
     * <p>
     * Space Complexity: O(1)
     * - No additional space needed
     */
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}