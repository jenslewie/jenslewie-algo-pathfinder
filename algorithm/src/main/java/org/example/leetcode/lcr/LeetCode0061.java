package org.example.leetcode.lcr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/qn8gGX/">LCR 061: 查找和最小的K对数字</a>
 * <p>
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。<br>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。<br>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Min-heap over pair sums. <br>
 * - Initialize with pairs (i, 0). <br>
 * - Pop smallest and push next pair in the row.
 * <p>
 * Time Complexity: O(k * log(min(n, k))) <br>
 * - n: length of nums1; heap size bounded by min(n, k).
 * <p>
 * Space Complexity: O(min(n, k)) <br>
 * - Heap stores one pair per nums1 index.
 */
public class LeetCode0061 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
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
