package org.example.leetcode.global;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-ii">...</a>
 * Approach 1: Monotonic stack with double traversal
 */
public class LeetCode0503_1 {

    /**
     * Find next greater elements in circular array using monotonic stack with double traversal
     * Time Complexity: O(n)
     * - n: length of nums
     * - Single pass through 2*n elements
     * <p>
     * Space Complexity: O(n)
     * - Deque to store indices
     * - Result array of size n
     */
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