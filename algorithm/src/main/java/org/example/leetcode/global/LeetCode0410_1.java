package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://leetcode.cn/problems/split-array-largest-sum">...</a>
 * Binary search approach
 */
public class LeetCode0410_1 {

    /**
     * Binary search approach to split array into k subarrays with minimized largest sum
     * Time Complexity: O(n * log(sum - max))
     * - n: length of the array
     * - Binary search on the answer range
     * <p>
     * Space Complexity: O(1)
     * - Only using constant extra space
     */
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (k >= get(nums, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int get(int nums[], int mid) {
        int result = 0, temp = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int num : nums) {
            if (temp + num > mid) {
                temp = num;
                result++;
                list.add(subList);
                subList = new ArrayList<>();
                subList.add(temp);
            } else {
                temp += num;
                subList.add(num);
            }
        }
        list.add(subList);
        return result + 1;
    }
}