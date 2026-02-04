package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/min-stack">LeetCode 155: Min Stack</a>
 * <p>
 * Approach: Interface for min-supporting stacks. <br>
 * - Defines operations to push, pop, top, and getMin. <br>
 * - Implementations provide O(1) getMin.
 * <p>
 * Time Complexity: O(1) per operation <br>
 * - Implementations are expected to be constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Implementations store up to n elements.
 */
public interface MinStack {
    void push(int val);

    void pop();

    int top();

    int getMin();
}
