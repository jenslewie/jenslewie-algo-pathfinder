package org.example.leetcode.global;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii">LeetCode 219: Contains Duplicate II</a>
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Sliding window with HashSet. <br>
 * - Maintain a window of at most k elements. <br>
 * - If a value repeats within the window, return true.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is added/removed at most once.
 * <p>
 * Space Complexity: O(min(n, k)) <br>
 * - Set stores up to k + 1 elements.
 */
public class LeetCode0219_2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right++]);
            while (right - left > k) {
                set.remove(nums[left++]);
            }
        }
        return false;
    }
}
