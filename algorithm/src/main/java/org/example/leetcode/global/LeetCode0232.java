package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks">LeetCode 232: Implement Queue using Stacks</a>
 * <p>
 * Approach: Two stacks (in/out). <br>
 * - Push to inStack. <br>
 * - For pop/peek, move elements to outStack if needed to reverse order.
 * <p>
 * Time Complexity: O(1) amortized <br>
 * - Each element moves from inStack to outStack at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Two stacks store all elements.
 */
public class LeetCode0232 {

    private final Stack<Integer> inStack, outStack;

    public LeetCode0232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
