package org.example.leetcode.global;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-ii">LeetCode 503: Next Greater Element II</a>
 * <p>
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums. <br>
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Monotonic stack with reverse traversal. <br>
 * - Traverse from right to left twice to simulate circularity. <br>
 * - Maintain a decreasing stack of values.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and result array.
 */
public class LeetCode0503_2 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        for (int i = 2 * len - 1; i >= 0; i--) {
            int j = i % len;
            while (!stack.isEmpty() && stack.peek() <= nums[j]) {
                stack.pop();
            }
            ans[j] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[j]);
        }
        return ans;
    }
}
