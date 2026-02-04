package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sort-colors">LeetCode 75: Sort Colors</a>
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. <br>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively. <br>
 * You must solve this problem without using the library's sort function. <br>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Counting with a fixed-size map. <br>
 * - Count occurrences of 0, 1, 2. <br>
 * - Overwrite the array in order using the counts.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; counting + rewrite each visit once.
 * <p>
 * Space Complexity: O(1) <br>
 * - Fixed-size map for three colors.
 */
public class LeetCode0075_4 {

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
