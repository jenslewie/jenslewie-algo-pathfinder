package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

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
 * Approach: Singly linked list with head/tail. <br>
 * - Enqueue at tail and dequeue at head. <br>
 * - Track size to enforce capacity.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(k) <br>
 * - Nodes stored up to capacity.
 */
public class LeetCode0622_3 {

    ListNode head;
    ListNode tail;
    int capacity;
    int size;

    public LeetCode0622_3(int k) {
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (head == null) {
            tail = head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
