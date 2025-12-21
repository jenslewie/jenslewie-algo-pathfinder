package org.example.leetcode.global;

import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/contains-duplicate-iii/description/
 */
public class LeetCode0220 {

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

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
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
