package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/wtcaE1/">LCR 016: 无重复字符的最长子串</a>
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with frequency map. <br>
 * - Expand right and count chars. <br>
 * - Shrink left while duplicates exist.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character processed at most twice.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: character set size.
 */
public class LCR0016_2 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char d = s.charAt(left++);
                map.put(d, map.get(d) - 1);
            }
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}