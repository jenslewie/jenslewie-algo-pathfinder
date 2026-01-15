package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/shortest-unsorted-continuous-subarray">...</a>
 */
public class LeetCode0581 {

    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
            return 0;
        }
        return right - left + 1;
    }

}
