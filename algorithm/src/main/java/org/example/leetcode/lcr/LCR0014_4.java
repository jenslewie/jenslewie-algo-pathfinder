package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/MPnaiL/">LCR 014: 字符串的排列</a>
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。<br>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with HashMap. <br>
 * - Track counts for target characters in maps. <br>
 * - Maintain valid count to detect matches.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s2; linear scan.
 * <p>
 * Space Complexity: O(k) <br>
 * - k: number of unique characters in s1.
 */
public class LCR0014_4 {

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