package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue">...</a>
 * input:   10, 6, 8, 5, 11, 9
 * expect:  3, 1, 2, 1, 1, 0
 * i    h[i]  stack1.    stack2     ans
 * 0    10    []         [0]
 * 1    6     [0]        [0, 1]     ans[0] = 1
 * 2    8     [0, 1].    [0, 2]     ans[1] = 1, ans[0] = 2
 * 3    5     [0, 2].    [0, 2, 3]  ans[2] = 1
 * 4    11    [0, 2, 3]  [4]        ans[3] = 1, ans[2] = 2, ans[0] = 3
 * 5    9     [4].       [4, 5]     ans[4] = 1
 * stack1 means before pushing the value to the stack
 * stack2 means after pushing the value to the stack
 */
public class LeetCode1944_2 {

    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                ans[stack.pop()]++;
            }
            if (!stack.isEmpty()) {
                ans[stack.peek()]++;
            }
            stack.push(i);
        }
        return ans;
    }

}
