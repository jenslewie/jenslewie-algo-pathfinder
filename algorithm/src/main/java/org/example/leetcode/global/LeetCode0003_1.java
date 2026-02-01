package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LeetCode0003_1 {

    /**
     * Use map to record each character position
     * Time Complexity: O(n)
     * - n: length of the string
     * - We iterate through each character once
     * <p>
     * Space Complexity: O(min(m,n))
     * - m: size of the charset (number of distinct characters in the string)
     * - Map stores at most min(m,n) characters
     */
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