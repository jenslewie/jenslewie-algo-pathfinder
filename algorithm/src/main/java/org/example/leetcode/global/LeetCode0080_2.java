package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii">LeetCode 80: Remove Duplicates from Sorted Array II</a>
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
