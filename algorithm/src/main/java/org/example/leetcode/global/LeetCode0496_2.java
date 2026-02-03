package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i">LeetCode 496: Next Greater Element I</a>
 * <p>
 * Approach: Monotonic stack from left to right. <br>
 * - Maintain a decreasing stack and resolve next greater when a larger value appears. <br>
 * - Use a map to answer nums1 queries.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m: length of nums1; n: length of nums2.
 * <p>
 * Space Complexity: O(n) <br>
 * - Map and stack store elements from nums2.
 */
public class LeetCode0496_2 {

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
