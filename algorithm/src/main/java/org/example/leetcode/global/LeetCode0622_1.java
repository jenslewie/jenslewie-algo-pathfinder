package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/design-circular-queue">LeetCode 622: Design Circular Queue</a>
 * <p>
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer". <br>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values. <br>
 * Implement the MyCircularQueue class: <br>
 * You must solve the problem without using the built-in queue data structure in your programming language.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Fixed-size array with head/tail and size. <br>
 * - Use modulo indexing for circular behavior. <br>
 * - Track size to distinguish empty/full.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(k) <br>
 * - Array of capacity k.
 */
public class LeetCode0622_1 {

    int[] queue;
    int head;
    int tail;
    int size;

    public LeetCode0622_1(int k) {
        queue = new int[k];
        head = 0;
        tail = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % queue.length;
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        queue[head] = -1;
        head = (head + 1) % queue.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

}
