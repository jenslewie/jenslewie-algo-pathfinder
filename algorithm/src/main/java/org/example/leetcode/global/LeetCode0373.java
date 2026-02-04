package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums">LeetCode 373: Find K Pairs with Smallest Sums</a>
 * <p>
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k. <br>
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array. <br>
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Min-heap over pair sums. <br>
 * - Initialize heap with pairs (i, 0) for nums1 and nums2[0]. <br>
 * - Pop smallest and push next pair in the same row.
 * <p>
 * Time Complexity: O(k * log(min(n, k)) <br>
 * - n: length of nums1; heap size is bounded by min(n, k).
 * <p>
 * Space Complexity: O(min(n, k)) <br>
 * - Heap stores at most one pair per nums1 index.
 */
public class LeetCode0373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!queue.isEmpty() && k > 0) {
            int[] cur = queue.poll();
            int i = cur[1], j = cur[2];
            if (j + 1 < nums2.length) {
                queue.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            res.add(List.of(nums1[i], nums2[j]));
            k--;
        }

        return res;
    }

}
