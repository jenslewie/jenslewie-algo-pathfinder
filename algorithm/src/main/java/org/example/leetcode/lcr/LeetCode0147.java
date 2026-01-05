package org.example.leetcode.lcr;

import java.util.Stack;

public class LeetCode0147 {

    Stack<int[]> stack;

    /** initialize your data structure here. */
    public LeetCode0147() {
        stack = new Stack<>();
        stack.push(new int[]{0, Integer.MAX_VALUE});
    }

    public void push(int x) {
        stack.push(new int[]{x, Math.min(stack.peek()[1], x)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

}
