package org.example.leetcode.lcr;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/qn8gGX/description/
 */
public class LeetCode0061 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !queue.isEmpty()) {
            int[] tmp = queue.poll();
            int i = tmp[1], j = tmp[2];
            if (j + 1 < nums2.length) {
                queue.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            result.add(List.of(nums1[i], nums2[j]));
        }

        return result;
    }

}
