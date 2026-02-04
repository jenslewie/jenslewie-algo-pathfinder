package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring">LeetCode 76: Minimum Window Substring</a>
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "". <br>
 * The testcases will be generated such that the answer is unique. <br>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * <p>
 * Difficulty: Hard
 * <p>
 * Approach: Sliding window with frequency maps. <br>
 * - Expand right to satisfy all needed characters. <br>
 * - Shrink left to minimize the window while maintaining validity.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(k) <br>
 * - k: number of distinct characters tracked in the maps.
 */
public class LeetCode0076 {

    public String minWindow(String s, String t) {
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c2 = s.charAt(left++);
                if (needs.containsKey(c2)) {
                    if (window.get(c2).equals(needs.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
