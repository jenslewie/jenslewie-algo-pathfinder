package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i">...</a>
 * Approach 1: Monotonic stack from right to left
 */
public class LeetCode0496_1 {

    /**
     * Find next greater element using monotonic stack from right to left
     * Time Complexity: O(m + n)
     * - m: length of nums1
     * - n: length of nums2
     * - Single pass through nums2 to build map + single pass through nums1 to get results
     * <p>
     * Space Complexity: O(n)
     * - Hash map to store next greater elements for each number in nums2
     * - Stack for monotonic processing
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}