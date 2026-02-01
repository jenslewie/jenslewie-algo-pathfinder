package org.example.leetcode.global;

import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/contains-duplicate-iii/description/
 * TreeSet approach
 */
public class LeetCode0220_1 {

    /**
     * TreeSet approach to find nearby almost duplicates
     * Time Complexity: O(n * log(min(n, indexDiff)))
     * - n: length of the input array
     * - For each element, we perform TreeSet operations that take O(log(size))
     * <p>
     * Space Complexity: O(min(n, indexDiff))
     * - TreeSet stores at most indexDiff elements
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) valueDiff);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) valueDiff) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}