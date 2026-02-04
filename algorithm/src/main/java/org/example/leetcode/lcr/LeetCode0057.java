package org.example.leetcode.lcr;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/7WqeDu/">LCR 057: 存在重复元素III</a>
 * <p>
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。<br>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * Difficulty: Medium
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
