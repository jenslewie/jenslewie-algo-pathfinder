package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof">LeetCode LCR 172: Count Target in Sorted Array</a>
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. <br>
 * If target is not found in the array, return [-1, -1]. <br>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Binary search for bounds. <br>
 - Find left bound of target. <br>
 - Find left bound of target + 1 to get right bound.
 * <p>
 * Time Complexity: O(log(n)) <br>
 * - n: length of the array; two binary searches.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode0172 {

    public int countTarget(int[] scores, int target) {
        int left = leftBound(scores, target);
        if (left == scores.length || scores[left] != target) {
            return 0;
        }

        int right = leftBound(scores, target + 1) - 1;
        return right - left + 1;
    }

    private int leftBound(int[] scores, int target) {
        int left = 0, right = scores.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > scores[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
