package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/design-circular-deque">LeetCode 641: Design Circular Deque</a>
 * <p>
 * Design your implementation of the circular double-ended queue (deque). <br>
 * Implement the MyCircularDeque class:
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Array with shift on insertFront. <br>
 * - Shift elements to make space at the front. <br>
 * - Use head/tail indices and size for state.
 * <p>
 * Time Complexity: O(n) for insertFront, O(1) for others <br>
 * - Shifting elements costs linear time.
 * <p>
 * Space Complexity: O(k) <br>
 * - Array of capacity k.
 */
public class LeetCode0641_1 {

    int[] queue;
    int head, tail, size, capacity;

    public LeetCode0641_1(int k) {
        queue = new int[k];
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        for (int i = tail; i > head; i--) {
            queue[i % capacity] = queue[(i - 1) % capacity];
        }
        tail++;
        queue[head % capacity] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail % capacity] = value;
        tail++;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head++;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail--;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : queue[head % capacity];
    }

    public int getRear() {
        return isEmpty() ? -1 : queue[(tail - 1) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
