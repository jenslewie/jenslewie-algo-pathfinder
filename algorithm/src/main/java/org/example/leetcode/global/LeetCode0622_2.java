package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/design-circular-queue">LeetCode 622: Design Circular Queue</a>
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
