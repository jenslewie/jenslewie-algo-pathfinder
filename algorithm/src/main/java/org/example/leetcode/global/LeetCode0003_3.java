package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">LeetCode 3: Longest Substring Without Repeating Characters</a>
 * <p>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with frequency map. <br>
 * - Expand right pointer and increment counts. <br>
 * - While a character count exceeds 1, move left pointer and decrement counts.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is processed at most twice.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: size of the character set; map stores at most min(m, n) entries.
 */
public class LeetCode0003_3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        map.values().stream().allMatch(v -> v <= 0);
        return max;
    }
}
