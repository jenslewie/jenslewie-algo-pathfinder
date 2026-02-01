package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/contains-duplicate-ii/description/
 * Brute force approach
 */
public class LeetCode0219_3 {

    /**
     * Brute force approach to find nearby duplicates
     * Time Complexity: O(n*k)
     * - n: length of the input array
     * - For each element, check at most k neighbors
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space
     */
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