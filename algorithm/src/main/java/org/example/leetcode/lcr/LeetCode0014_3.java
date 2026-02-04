package org.example.leetcode.lcr;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/MPnaiL/">LCR 014: 字符串的排列</a>
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。<br>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串。
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