package org.example.leetcode.global;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-iii">LeetCode 220: Contains Duplicate III</a>
 * <p>
 * Approach: TreeSet sliding window with range query. <br>
 * - Keep a TreeSet of the last indexDiff elements. <br>
 * - Use ceiling/floor to check if any value is within valueDiff.
 * <p>
 * Time Complexity: O(n * log(min(n, indexDiff))) <br>
 * - n: length of the array; each TreeSet operation is logarithmic.
 * <p>
 * Space Complexity: O(min(n, indexDiff)) <br>
 * - TreeSet stores up to indexDiff elements.
 */
public class LeetCode0220_1 {

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
