package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/MPnaiL/description/
 * Approach 4: Using HashMap for flexible character mapping
 */
public class LeetCode0014_4 {

    /**
     * Check if s2 contains a permutation of s1 using HashMap for character counting
     * Time Complexity: O(n)
     * - n: length of s2
     * - Single pass through s2 with two pointers
     * <p>
     * Space Complexity: O(k)
     * - k: number of unique characters in s1
     * - HashMap storage for character counts
     */
    public boolean checkInclusion(String s1, String s2) {
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