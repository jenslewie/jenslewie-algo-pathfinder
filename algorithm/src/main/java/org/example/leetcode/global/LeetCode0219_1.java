package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/contains-duplicate-ii/description/
 * HashMap approach
 */
public class LeetCode0219_1 {

    /**
     * HashMap approach to find nearby duplicates
     * Time Complexity: O(n)
     * - n: length of the input array
     * - Single pass through the array
     * <p>
     * Space Complexity: O(min(n,k))
     * - Hash map stores at most n elements
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}