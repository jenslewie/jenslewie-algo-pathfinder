package org.example.leetcode.global;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum">...</a>
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
