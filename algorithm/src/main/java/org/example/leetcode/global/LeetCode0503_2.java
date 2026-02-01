package org.example.leetcode.global;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-ii">...</a>
 * Approach 2: Monotonic stack with reverse traversal
 */
public class LeetCode0503_2 {

    /**
     * Find next greater elements in circular array using monotonic stack with reverse traversal
     * Time Complexity: O(n)
     * - n: length of nums
     * - Single pass through 2*n elements
     * <p>
     * Space Complexity: O(n)
     * - Deque to store values
     * - Result array of size n
     */
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