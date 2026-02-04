package org.example.leetcode.global;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence">LeetCode 128: Longest Consecutive Sequence</a>
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. <br>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: <br>
 * - Use a HashSet to store all numbers for O(1) lookups. <br>
 * - For each number, only start counting if it's the beginning of a sequence (i.e., num-1 is not in the set). <br>
 * - However, this implementation uses a different optimization: it starts from the end of a sequence (num+1 not present) <br>
 * and counts backwards to find the full length. <br>
 * - Includes an early termination optimization: if current max length >= half of total unique elements, <br>
 * no longer sequence is possible.
 * <p>
 * Time Complexity: O(n) <br>
 * - Each element is visited at most twice: once in the outer loop, once in the inner while loop. <br>
 * - The early break condition ensures we don't do unnecessary work. <br>
 * <p>
 * Space Complexity: O(n) <br>
 * - For storing the input array in a HashSet. <br>
 */
public class LeetCode0128 {

    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();

        int ans = 0;
        for (int num : set) {
            if (set.contains(num + 1)) {
                continue;
            }
            int prev = num - 1;
            while (set.contains(prev)) {
                prev--;
            }
            ans = Math.max(ans, num - prev);
            if (ans * 2 >= size) {
                break;
            }
        }

        return ans;
    }

}
