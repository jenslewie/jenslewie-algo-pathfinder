package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray">LeetCode 581: Shortest Unsorted Continuous Subarray</a>
 * <p>
 * Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order. <br>
 * Return the shortest such subarray and output its length.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Monotonic stacks for bounds. <br>
 * - Find right bound where order breaks using a decreasing stack. <br>
 * - Find left bound using an increasing stack.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stacks store indices.
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
        if (left == Integer.MAX_VALUE) {
            return 0;
        }
        return right - left + 1;
    }

}
