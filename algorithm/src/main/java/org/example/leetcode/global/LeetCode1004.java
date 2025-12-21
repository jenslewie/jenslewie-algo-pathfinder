package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 */
public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) {
                queue.offer(right - 1);
            }
            if (k < queue.size()) {
                maxLen = Math.max(maxLen, right - left - 1);
                left = queue.pollFirst() + 1;
            }
        }
        return Math.max(maxLen, right - left);
    }

    public int longestOnes2(int[] nums, int k) {
        int left = 0, right = 0;
        int windowOneCount = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                windowOneCount++;
            }
            right++;
            while (right - left - windowOneCount > k) {
                if(nums[left] == 1) {
                    windowOneCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}
