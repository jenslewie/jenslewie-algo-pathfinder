package org.example.leetcode.global;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k">LeetCode 560: Subarray Sum Equals K</a>
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k. <br>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Prefix sum with frequency hashmap. <br>
 * - Maintain running prefix sum while scanning the array once. <br>
 * - For each position, add count of prior prefix sums equal to currentSum - k.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: each element is processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Prefix map can store up to n distinct sums.
 */
public class LeetCode0560_2 {

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

}
