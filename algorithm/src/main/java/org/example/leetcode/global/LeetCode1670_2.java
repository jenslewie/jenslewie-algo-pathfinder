package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/design-front-middle-back-queue">...</a>
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
