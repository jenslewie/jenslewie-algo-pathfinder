package org.example.leetcode.global;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-iii">LeetCode 220: Contains Duplicate III</a>
 * <p>
 * You are given an integer array nums and two integers indexDiff and valueDiff. <br>
 * Find a pair of indices (i, j) such that: <br>
 * Return true if such pair exists or false otherwise.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: TreeSet sliding window with floor/ceiling. <br>
 * - Keep a TreeSet of at most indexDiff recent values. <br>
 * - Check nearest neighbors within valueDiff.
 * <p>
 * Time Complexity: O(n * log(min(n, indexDiff))) <br>
 * - n: length of the array; each TreeSet operation is logarithmic.
 * <p>
 * Space Complexity: O(min(n, indexDiff)) <br>
 * - TreeSet stores up to indexDiff elements.
 */
public class LeetCode0220_2 {

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
