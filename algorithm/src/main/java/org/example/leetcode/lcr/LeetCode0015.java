package org.example.leetcode.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/VabMRr/">LeetCode LCR 015: Find All Anagrams in a String</a>
 * <p>
 * Approach: Sliding window with count arrays. <br>
 - Compare window counts with target counts. <br>
 - Record indices where they match.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s; each window shift is O(1) for 26 letters.
 * <p>
 * Space Complexity: O(1) <br>
 * - Two 26-length arrays.
 */
public class LeetCode0015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return result;
        }

        int[] window = new int[26];
        int[] need = new int[26];
        for (int i = 0; i < n; i++) {
            window[s.charAt(i) - 'a']++;
            need[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(window, need)) {
            result.add(0);
        }

        for (int i = n; i < m; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(window, need)) {
                result.add(i - n + 1);
            }
        }

        return result;
    }

}
