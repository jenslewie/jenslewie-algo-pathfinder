package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/design-circular-deque">LeetCode 641: Design Circular Deque</a>
 * <p>
 * Approach: Doubly linked list. <br>
 * - Insert/delete at both ends in O(1). <br>
 * - Track size to enforce capacity.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(k) <br>
 * - Nodes stored up to capacity.
 */
public class LeetCode0641_3 {

    ListNode head;
    ListNode tail;
    int size, capacity;

    public LeetCode0641_3(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        ListNode node = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        node.next = null;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        ListNode node = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        node.prev = null;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
