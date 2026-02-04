package org.example.leetcode.lcr;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof">LCR 147: 最小栈</a>
 * <p>
 * 请你设计一个 最小栈 。它提供 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。<br>
 * 实现 MinStack 类：<br>
 * · MinStack() 初始化堆栈对象。<br>
 * · void push(int val) 将元素val推入堆栈。<br>
 * · void pop() 删除堆栈顶部的元素。<br>
 * · int top() 获取堆栈顶部的元素。<br>
 * · int getMin() 获取堆栈中的最小元素。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Stack of [value, min] pairs. <br>
 * - Each node stores the current minimum. <br>
 * - getMin reads top pair.
 * <p>
 * Time Complexity: O(1) <br>
 * - All operations are constant time.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores one pair per element.
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
