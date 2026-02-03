package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/remove-k-digits">...</a>
 */
public class LeetCode0402_3 {

    public String removeKdigits(String num, int k) {
        int[] stack = new int[num.length() + 1];
        char[] nums = num.toCharArray();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (index > 0 && k > 0 && nums[stack[index]] > nums[i]) {
                index--;
                k--;
            }
            stack[++index] = i;
        }

        if (k > 0) {
            index = Math.max(0, index - k);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= index; i++) {
            if (sb.isEmpty() && nums[stack[i]] == '0') {
                continue;
            }
            sb.append(nums[stack[i]]);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

}
