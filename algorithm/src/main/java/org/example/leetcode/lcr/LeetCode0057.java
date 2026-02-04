package org.example.leetcode.lcr;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/7WqeDu/">LeetCode LCR 057: Contains Duplicate III</a>
 * <p>
 * You are given an integer array nums and two integers indexDiff and valueDiff. <br>
 * Find a pair of indices (i, j) such that: <br>
 * Return true if such pair exists or false otherwise.
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: TreeSet sliding window. <br>
 * - Maintain last k elements in a TreeSet. <br>
 * - Use ceiling to check valueDiff range.
 * <p>
 * Time Complexity: O(n * log(k)) <br>
 * - n: array length; each TreeSet op is log(k).
 * <p>
 * Space Complexity: O(k) <br>
 * - TreeSet stores up to k elements.
 */
public class LeetCode0057 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
