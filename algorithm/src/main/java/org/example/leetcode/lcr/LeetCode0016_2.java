package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/wtcaE1/">...</a>
 * Sliding window with map approach
 */
public class LeetCode0016_2 {

    /**
     * Sliding window with map approach to find the length of the longest substring without repeating characters
     * Time Complexity: O(n)
     * - n: length of the input string
     * - Each character is visited exactly once
     * <p>
     * Space Complexity: O(min(m,n))
     * - Where m is the size of the character set and n is the length of the string
     */
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