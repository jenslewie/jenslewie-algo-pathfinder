package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted">LeetCode 167: Two Sum II - Input Array Is Sorted</a>
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length. <br>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2. <br>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice. <br>
 * Your solution must use only constant extra space.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two pointers. <br>
 * - Use left and right pointers on the sorted array. <br>
 * - Move pointers based on sum comparison with target.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Only constant extra space is used.
 */
public class LeetCode0167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }

}
