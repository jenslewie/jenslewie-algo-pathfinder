package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/description/
 */
public class LeetCode0373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

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
