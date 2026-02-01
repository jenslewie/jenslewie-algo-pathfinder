package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LeetCode0003_3 {

    /**
     * Use map to record each character occurrence times
     * Time Complexity: O(n)
     * - n: length of the string
     * - Each character is visited at most twice (once by right pointer, once by left pointer)
     * <p>
     * Space Complexity: O(min(m,n))
     * - m: size of the charset (number of distinct characters in the string)
     * - Map stores at most min(m,n) characters
     */
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