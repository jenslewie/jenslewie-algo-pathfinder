package org.example.leetcode.lcr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/MPnaiL/description/
 * Approach 3: Using sliding window with explicit size check
 */
public class LeetCode0014_3 {

    /**
     * Check if s2 contains a permutation of s1 using sliding window with explicit size check
     * Time Complexity: O(n)
     * - n: length of s2
     * - Single pass through s2 with two pointers
     * <p>
     * Space Complexity: O(1)
     * - Fixed size arrays of 26 elements for character counting
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26];
        int[] need = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            int i = s2.charAt(right++) - 'a';
            if (need[i] > 0) {
                window[i]++;
            }

            while (right - left >= s1.length()) {
                if (Arrays.equals(need, window)) {
                    return true;
                }
                int j = s2.charAt(left++) - 'a';
                if (need[j] > 0) {
                    window[j]--;
                }
            }
        }
        return false;
    }
}