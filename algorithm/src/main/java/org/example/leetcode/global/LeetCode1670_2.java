package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/design-front-middle-back-queue">LeetCode 1670: Design Front Middle Back Queue</a>
 * <p>
 * Design a queue that supports push and pop operations in the front, middle, and back. <br>
 * Implement the FrontMiddleBack class: <br>
 * Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two deques (left/right). <br>
 * - Keep sizes balanced so right is equal or one larger. <br>
 * - Operations adjust and rebalance as needed.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Store all elements across two deques.
 */
public class LeetCode1670_2 {

    Deque<Integer> left;
    Deque<Integer> right;

    public LeetCode1670_2() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.offerLast(val);
        } else {
            right.offerFirst(val);
        }
    }

    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }

    public int popFront() {
        if (right.isEmpty()) {
            return -1;
        }
        int value = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return value;
    }

    public int popMiddle() {
        if (right.isEmpty()) {
            return -1;
        }
        if (left.size() < right.size()) {
            return right.pollFirst();
        }
        return left.pollLast();
    }

    public int popBack() {
        if (right.isEmpty()) {
            return -1;
        }
        int value = right.pollLast();
        balance();
        return value;
    }

    private void balance() {
        if (right.size() - left.size() == 2) {
            left.offerLast(right.pollFirst());
        } else if (left.size() - right.size() == 1) {
            right.offerFirst(left.pollLast());
        }
    }

}
