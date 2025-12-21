package org.example.leetcode.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/VabMRr/
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
