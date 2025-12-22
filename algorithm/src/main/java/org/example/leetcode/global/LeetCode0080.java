package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/">...</a>
 */
public class LeetCode0080 {

    public int removeDuplicates1(int[] nums) {
        int slow = 0;
        for (int num : nums) {
            if (slow < 2 || num > nums[slow - 2]) {
                nums[slow++] = num;
            }
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {
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

    public int removeDuplicates3(int[] nums) {
        int slow = 0, fast = 0, count = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                nums[++slow] = nums[fast];
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                count = 0;
            }
        }
        return slow + 1;
    }

}
