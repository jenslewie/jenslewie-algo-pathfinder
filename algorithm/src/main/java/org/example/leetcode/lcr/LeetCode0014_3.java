package org.example.leetcode.lcr;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/MPnaiL/description/">LeetCode LCR 014: Permutation in String</a>
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise. <br>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with size check. <br>
 * - Track counts for needed characters only. <br>
 * - Compare arrays when window size matches.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s2; linear scan.
 * <p>
 * Space Complexity: O(1) <br>
 * - Fixed-size arrays of 26 counts.
 */
public class LeetCode0014_3 {

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