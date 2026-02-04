package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string">LeetCode 567: Permutation in String</a>
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise. <br>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with frequency maps. <br>
 * - Track counts for the current window and target string. <br>
 * - Check for full match when the window size equals s1 length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s2; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(k) <br>
 * - k: number of distinct characters in s1.
 */
public class LeetCode0567 {

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int valid = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left++);
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

}
