package org.example.leetcode.lcr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/MPnaiL/description/
 */
public class LeetCode0014 {

    public boolean checkInclusion1(String s1, String s2) {
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

    public boolean checkInclusion2(String s1, String s2) {
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

    public boolean checkInclusion3(String s1, String s2) {
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

    public boolean checkInclusion4(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (need.size() == valid) {
                    return true;
                }
                char d = s2.charAt(left++);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

}
