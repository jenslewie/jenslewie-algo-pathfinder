package org.example.leetcode.global;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum">LeetCode 1: Two Sum</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. <br>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice. <br>
 * You can return the answer in any order.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: HashMap lookup. <br>
 * - Traverse once, storing value -> index. <br>
 * - For each number, check if target - num already exists.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - HashMap stores up to n elements.
 */
public class LeetCode0001 {

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
