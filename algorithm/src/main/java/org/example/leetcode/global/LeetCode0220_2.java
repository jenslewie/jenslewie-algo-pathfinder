package org.example.leetcode.global;

import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/contains-duplicate-iii/description/
 * TreeSet sliding window approach
 */
public class LeetCode0220_2 {

    /**
     * TreeSet sliding window approach to find nearby almost duplicates
     * Time Complexity: O(n * log(min(n, indexDiff)))
     * - n: length of the input array
     * - For each element, we perform TreeSet operations that take O(log(size))
     * <p>
     * Space Complexity: O(min(n, indexDiff))
     * - TreeSet stores at most indexDiff elements
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            Integer ceiling = set.ceiling(nums[right]);
            if (ceiling != null && (long) ceiling - nums[right] <= valueDiff) {
                return true;
            }
            Integer floor = set.floor(nums[right]);
            if (floor != null && (long) nums[right] - floor <= valueDiff) {
                return true;
            }

            set.add(nums[right++]);

            if (right - left > indexDiff) {
                set.remove(nums[left++]);
            }
        }
        return false;
    }
}