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
 * Approach: Sliding window with last-seen map. <br>
 * - Move left pointer past the last occurrence of a duplicate. <br>
 * - Track maximum window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character processed once.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: character set size.
 */
public class LeetCode0016_1 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c) + 1;
            }
            map.put(c, right++);
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}