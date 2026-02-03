package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii">LeetCode 219: Contains Duplicate II</a>
 * <p>
 * Approach: HashMap of last seen indices. <br>
 * - Store the most recent index for each value. <br>
 * - Check if the index difference is within k.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(min(n, k)) <br>
 * - Map stores at most one entry per distinct value.
 */
public class LeetCode0219_1 {

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
