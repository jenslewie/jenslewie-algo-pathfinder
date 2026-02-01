package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://leetcode.cn/problems/split-array-largest-sum">...</a>
 * Alternative binary search approach
 */
public class LeetCode0410_2 {

    /**
     * Alternative binary search approach to split array into k subarrays with minimized largest sum
     * Time Complexity: O(n * log(sum - max))
     * - n: length of the array
     * - Binary search on the answer range
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space
     */
    public int splitArray(int[] nums, int k) {
        int mx = 0;
        int sum = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
            sum += x;
        }

        int low = mx - 1;
        int high = sum;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (check(nums, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private boolean check(int[] nums, int k, int mx) {
        int cnt = 1;
        int s = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int x : nums) {
            if (s + x <= mx) {
                s += x;
                subList.add(x);
                continue;
            }
            if (cnt == k) {
                return false;
            }
            cnt++;
            s = x;
            list.add(subList);
            subList = new ArrayList<>();
            subList.add(x);
        }
        list.add(subList);
        return true;
    }
}