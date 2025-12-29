package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues">...</a>
 */
public class LeetCode0225 {

    private Queue<Integer> mainQueue, tempQueue;
    private int size;

    public LeetCode0225() {
        mainQueue = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
        size = 0;
    }

    public void push(int x) {
        mainQueue.offer(x);
        for (int i = 0; i < size; i++) {
            mainQueue.offer(mainQueue.poll());
        }
        size++;
    }

    public int pop() {
        if (!mainQueue.isEmpty()) {
            size--;
            return mainQueue.poll();
        }
        return -1;
    }

    public int top() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.peek();
        }
        return -1;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }

    public void push2(int x) {
        tempQueue.offer(x);
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }
        mainQueue = tempQueue;
        tempQueue = new ArrayDeque<>();
    }

    public int pop2() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.poll();
        }
        return -1;
    }

    public int top2() {
        if (!mainQueue.isEmpty()) {
            return mainQueue.peek();
        }
        return -1;
    }

    public boolean empty2() {
        return mainQueue.isEmpty() && tempQueue.isEmpty();
    }

}
