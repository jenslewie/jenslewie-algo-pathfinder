package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum">LeetCode 410: Split Array Largest Sum</a>
 * <p>
 * Approach: Binary search with feasibility check. <br>
 * - Search the minimal maximum subarray sum. <br>
 * - Check if the array can be split into k parts within the limit.
 * <p>
 * Time Complexity: O(n * log(sum - max)) <br>
 * - n: length of the array; each check is linear.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0410_2 {

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
