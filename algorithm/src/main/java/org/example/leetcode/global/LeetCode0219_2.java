package org.example.leetcode.global;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/contains-duplicate-ii/description/
 * HashSet sliding window approach
 */
public class LeetCode0219_2 {

    /**
     * HashSet sliding window approach to find nearby duplicates
     * Time Complexity: O(n)
     * - n: length of the input array
     * - Each element is added and removed from the set at most once
     * <p>
     * Space Complexity: O(min(n,k))
     * - Set stores at most k+1 elements
     */
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