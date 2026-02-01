package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0014_3 {

    /**
     * Time Complexity: O(S)
     * - S: sum of all characters in all strings
     * - In the worst case, we iterate through all characters of all strings
     * <p>
     * Space Complexity: O(m)
     * - m: number of strings in the array
     * - Using a map to store character counts at each position
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            Map<Character, Integer> map = new HashMap<>();
            char c = ' ';
            for (String str : strs) {
                if (str.length() <= i) {
                    return sb.toString();
                }
                c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            if (map.get(c) == strs.length) {
                sb.append(c);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}