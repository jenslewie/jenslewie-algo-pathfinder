package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/min-stack">LeetCode 155: Min Stack</a>
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. <br>
 * Implement the MinStack class: <br>
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Stack of [value, min] pairs. <br>
 * - Each element stores its value and the minimum so far. <br>
 * - getMin is O(1) by peeking the top pair.
 * <p>
 * Time Complexity: O(1) <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores one pair per element.
 */
public class LeetCode0155_1 implements MinStack {

    private final Stack<int[]> stack;

    public LeetCode0155_1() {
        this.stack = new Stack<>();
        // Initialize with a sentinel value
        stack.push(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
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
        int currentMin = Math.min(stack.peek()[1], val);
        stack.push(new int[]{val, currentMin});
    }

    /**
     * Time Complexity: O(1)
     * - Pop operation takes constant time
     * <p>
     * Space Complexity: O(1)
     */
    @Override
    public void pop() {
        if (stack.size() > 1) {
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
        if (stack.size() > 1) {
            return stack.peek()[0];
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
        if (stack.size() > 1) {
            return stack.peek()[1];
        }
        throw new RuntimeException("Stack is empty");
    }
}
