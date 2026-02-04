package org.example.leetcode.global;

import org.example.model.linkedlist.ListNode;

/**
 * <a href="https://leetcode.cn/problems/design-front-middle-back-queue">LeetCode 1670: Design Front Middle Back Queue</a>
 * <p>
 * Design a queue that supports push and pop operations in the front, middle, and back. <br>
 * Implement the FrontMiddleBack class: <br>
 * Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Doubly linked list with middle pointer. <br>
 * - Maintain head/tail sentinels and a middle pointer. <br>
 * - Update middle as size changes.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Store all elements in the list.
 */
public class LeetCode1670_1 {

    ListNode head, middle, tail;
    int size;

    public LeetCode1670_1() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        middle = tail;
    }

    public void pushFront(int val) {
        ListNode node = new ListNode(val);
        insertAfter(head, node);
        size++;
        if (size == 1) {
            middle = node;
        } else if (size % 2 == 1) {
            middle = middle.prev;
        }
    }

    public void pushMiddle(int val) {
        ListNode node = new ListNode(val);
        insertBefore(middle, node);
        size++;
        if (size % 2 == 1) {
            middle = middle.prev;
        }
    }

    public void pushBack(int val) {
        ListNode node = new ListNode(val);
        insertBefore(tail, node);
        size++;
        if (size == 1) {
            middle = node;
        } else if (size % 2 == 0) {
            middle = middle.next;
        }
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }

        int val = remove(head.next);
        size--;
        if (size == 0) {
            middle = tail;
        } else if (size % 2 == 0) {
            middle = middle.next;
        }
        return val;
    }

    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }

        ListNode node;
        if (size % 2 == 1) {
            node = middle;
            middle = middle.next;
        } else {
            node = middle.prev;
        }
        int val = remove(node);
        size--;
        return val;
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }

        int val = remove(tail.prev);
        size--;
        if (size == 0) {
            middle = tail;
        } else if (size % 2 == 1) {
            middle = middle.prev;
        }
        return val;
    }

    private void insertAfter(ListNode prev, ListNode node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }

    private void insertBefore(ListNode next, ListNode node) {
        node.next = next;
        node.prev = next.prev;
        next.prev.next = node;
        next.prev = node;
    }

    private int remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        return node.val;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
