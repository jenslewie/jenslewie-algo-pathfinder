package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string">LeetCode 438: Find All Anagrams in a String</a>
 * <p>
 * Approach: Sliding window with frequency maps. <br>
 * - Track counts for the current window and the target. <br>
 * - Record indices where counts match.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(k) <br>
 * - k: number of distinct characters in the pattern.
 */
public class LeetCode0438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            if (right - left >= p.length()) {
                if (valid == need.size()) {
                    results.add(left);
                }
                char d = s.charAt(left++);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return results;
    }

}
