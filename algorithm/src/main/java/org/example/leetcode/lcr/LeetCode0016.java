package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/wtcaE1/
 */
public class LeetCode0016 {

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

    public int lengthOfLongestSubstring2(String s) {
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
