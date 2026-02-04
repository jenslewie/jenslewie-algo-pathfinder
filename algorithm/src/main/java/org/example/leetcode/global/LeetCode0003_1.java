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
 * Approach: Sliding window with last-seen index map. <br>
 * - Expand right pointer; when a duplicate is seen, move left past its last index. <br>
 * - Track maximum window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is processed once.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: size of the character set; map stores at most min(m, n) entries.
 */
public class LeetCode0003_1 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right++);
            max = Math.max(max, right - left);
        }

        return max;
    }
}
