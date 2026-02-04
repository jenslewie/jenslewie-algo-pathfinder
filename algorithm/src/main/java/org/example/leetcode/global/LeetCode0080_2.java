package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii">LeetCode 80: Remove Duplicates from Sorted Array II</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same. <br>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements. <br>
 * Return k after placing the final result in the first k slots of nums. <br>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory. <br>
 * Custom Judge: <br>
 * The judge will test your solution with the following code: <br>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Two pointers with explicit boundary. <br>
 * - Keep slow at the next write position, fast scans forward. <br>
 * - Allow a value if it differs from nums[slow - 2].
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the array; each element is processed once.
 * <p>
 * Space Complexity: O(1) <br>
 * - In-place update with constant extra space.
 */
public class LeetCode0080_2 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }

        int slow = 2, fast = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
