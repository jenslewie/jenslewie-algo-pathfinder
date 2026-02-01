package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">...</a>
 */
public class LeetCode0075_4 {

    /**
     * Counting approach with HashMap
     * Time Complexity: O(n)
     * - n: length of the array
     * - We iterate through the array twice
     * <p>
     * Space Complexity: O(1)
     * - Using fixed-size map for colors (0, 1, 2)
     */
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 0, 2, 0));
        for (int num : nums) {
            map.put(num, map.get(num) + 1);
        }
        int i = 0;
        for (int key : new int[]{0, 1, 2}) {
            int j = 0;
            while (map.get(key) > j) {
                nums[i++] = key;
                j++;
            }
        }
    }
}