package org.example.leetcode.lcr;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/MPnaiL/description/">LeetCode LCR 014: Permutation in String</a>
 * <p>
 * Approach: Sliding window with fixed arrays. <br>
 - Compare 26-length arrays for each window. <br>
 - Move the window one step at a time.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s2; each shift is O(1) for 26 letters. <br>
 * <p>
 * Space Complexity: O(1) <br>
 * - Two 26-length arrays. <br>
 */
public class LeetCode0014_2 {

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