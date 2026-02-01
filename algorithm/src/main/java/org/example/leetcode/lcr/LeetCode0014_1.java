package org.example.leetcode.lcr;

/**
 * https://leetcode.cn/problems/MPnaiL/description/
 * Approach 1: Using sliding window with count array
 */
public class LeetCode0014_1 {

    /**
     * Check if s2 contains a permutation of s1 using sliding window technique
     * Time Complexity: O(n)
     * - n: length of s2
     * - Single pass through s2 with two pointers
     * <p>
     * Space Complexity: O(1)
     * - Fixed size array of 26 elements for character counting
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            int index = s2.charAt(right) - 'a';
            cnt[index]++;
            while (cnt[index] > 0) {
                cnt[s2.charAt(left++) - 'a']--;
            }
            if (right - left + 1 == m) {
                return true;
            }
        }
        return false;
    }
}