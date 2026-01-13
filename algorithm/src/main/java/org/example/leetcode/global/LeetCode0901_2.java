package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode0901_2 {

    private final Deque<int[]> stack;
    private int currDay;

    public LeetCode0901_2() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        currDay = -1;
    }

    public int next(int price) {
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        currDay++;
        int ans = currDay - stack.peek()[0];
        stack.push(new int[]{currDay, price});
        return ans;
    }

}
