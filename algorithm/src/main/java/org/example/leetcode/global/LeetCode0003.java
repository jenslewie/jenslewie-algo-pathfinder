package org.example.leetcode.global;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LeetCode0003 {

    /**
     * Use map to record each character position
     * @param s
     * @return
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

    /**
     * Use set to record if character has already existed
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right++);
            boolean notExists = set.add(c);
            if (!notExists) {
                while (left < right && s.charAt(left) != c) {
                    set.remove(s.charAt(left++));
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    /**
     * Use map to record each character occurrence times
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
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
