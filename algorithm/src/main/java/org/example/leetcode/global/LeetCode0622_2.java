package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/design-circular-queue">LeetCode 622: Design Circular Queue</a>
 * <p>
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer". <br>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values. <br>
 * Implement the MyCircularQueue class: <br>
 * You must solve the problem without using the built-in queue data structure in your programming language.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Circular array with head/tail indices. <br>
 * - Use modulo indexing for wrap-around. <br>
 * - Full when tail - head equals capacity.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(k) <br>
 * - Array of capacity k.
 */
public class LeetCode0622_2 {

    int[] queue;
    int head, tail;

    public LeetCode0622_2(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail % queue.length] = value;
        tail++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[head % queue.length];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[(tail - 1) % queue.length];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == queue.length;
    }

}
