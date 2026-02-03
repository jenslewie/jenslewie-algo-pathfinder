package org.example.leetcode.lcr;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof">LeetCode LCR 147: Min Stack</a>
 * <p>
 * Approach: Stack of [value, min] pairs. <br>
 - Each node stores the current minimum. <br>
 - getMin reads top pair.
 * <p>
 * Time Complexity: O(1) <br>
 * - All operations are constant time. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores one pair per element. <br>
 */
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
