package org.example.leetcode.global;

public interface MinStack {
    void push(int val);

    void pop();

    int top();

    int getMin();
}