package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii">LeetCode 219: Contains Duplicate II</a>
 * <p>
 * Approach: Brute force scan within k. <br>
 * - For each index, compare up to k following elements. <br>
 * - Return true on the first match.
 * <p>
 * Time Complexity: O(n * k) <br>
 * - n: length of the array; check up to k neighbors per element.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0219_3 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
