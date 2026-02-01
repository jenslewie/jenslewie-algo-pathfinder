package org.example.leetcode.lcr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/MPnaiL/description/
 * Approach 2: Using fixed-size arrays for comparison
 */
public class LeetCode0014_2 {

    /**
     * Check if s2 contains a permutation of s1 using fixed-size array comparison
     * Time Complexity: O(n)
     * - n: length of s2
     * - Single pass through s2 with sliding window
     * <p>
     * Space Complexity: O(1)
     * - Fixed size arrays of 26 elements for character counting
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - m) - 'a']--;
            if (Arrays.equals(need, window)) {
                return true;
            }
        }
        return false;
    }
}