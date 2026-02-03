package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum">LeetCode 410: Split Array Largest Sum</a>
 * <p>
 * Approach: Binary search on the answer. <br>
 * - Search between max element and total sum. <br>
 * - Greedily count needed subarrays for each candidate sum.
 * <p>
 * Time Complexity: O(n * log(sum - max)) <br>
 * - n: length of the array; each check is linear.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0410_1 {

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
