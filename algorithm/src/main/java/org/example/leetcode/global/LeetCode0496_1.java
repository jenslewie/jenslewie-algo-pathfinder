package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i">LeetCode 496: Next Greater Element I</a>
 * <p>
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array. <br>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2. <br>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1. <br>
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Monotonic stack from right to left. <br>
 * - Build a map of each value's next greater element in nums2. <br>
 * - Answer queries for nums1 using the map.
 * <p>
 * Time Complexity: O(m + n) <br>
 * - m: length of nums1; n: length of nums2.
 * <p>
 * Space Complexity: O(n) <br>
 * - Map and stack store elements from nums2.
 */
public class LeetCode0496_1 {

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
