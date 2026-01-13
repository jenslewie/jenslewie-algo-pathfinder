package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue">...</a>
 * input:   10, 6, 8, 5, 11, 9
 * expect:  3, 1, 2, 1, 1, 0
 * i    h[i]  count  stack1      stack2      ans[i]
 * 5    9     0      []          [9]         0
 * 4    11    1      [9]         [11]        1
 * 3    5     0      [11]        [11, 5]     1
 * 2    8     1      [11, 5]     [11, 8]     2
 * 1    6     0      [11, 8]     [11, 8, 6]  1
 * 0    10    2      [11, 8, 6]  [11, 10]    3
 * stack1 means before pushing the value to the stack
 * stack2 means after pushing the value to the stack
 */
public class LeetCode1944_1 {

    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }
            ans[i] = stack.isEmpty() ? count : count + 1;
            stack.push(heights[i]);
        }
        return ans;
    }

}
