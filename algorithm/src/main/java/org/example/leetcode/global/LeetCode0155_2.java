package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/min-stack">LeetCode 155: Min Stack</a>
 * <p>
 * Approach: Two stacks (main + min). <br>
 * - Main stack stores values; min stack stores current minima. <br>
 * - Push to min stack when a new minimum appears.
 * <p>
 * Time Complexity: O(1) <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Two stacks store up to n elements.
 */
public class LeetCode0155_2 implements MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public LeetCode0155_2() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * Time Complexity: O(1)
     * - Push operation takes constant time
     * <p>
     * Space Complexity: O(1) for the operation itself
     * - But overall space is O(n) where n is the number of elements pushed
     */
    @Override
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    /**
     * Time Complexity: O(1)
     * - Pop operation takes constant time
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public void pop() {
        if (!stack.isEmpty()) {
            if (minStack.peek().equals(stack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    /**
     * Time Complexity: O(1)
     * - Peek operation takes constant time
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("Stack is empty");
    }

    /**
     * Time Complexity: O(1)
     * - Peek operation takes constant time
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("Stack is empty");
    }
}
