package org.example.leetcode.global;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-ii">LeetCode 503: Next Greater Element II</a>
 * <p>
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums. <br>
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Monotonic stack with double traversal. <br>
 * - Traverse the array twice to simulate circularity. <br>
 * - Use a stack of indices to resolve next greater elements.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each index is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack and result array.
 */
public class LeetCode0503_1 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for (int i = 0; i < len * 2; i++) {
            int j = i % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = nums[j];
            }
            if (i < len) {
                stack.push(i);
            }
        }
        return ans;
    }
}
