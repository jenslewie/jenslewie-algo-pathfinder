package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i">...</a>
 * Approach 2: Monotonic stack from left to right
 */
public class LeetCode0496_2 {

    /**
     * Find next greater element using monotonic stack from left to right
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
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}