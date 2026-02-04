package org.example.leetcode.global;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix">LeetCode 14: Longest Common Prefix</a>
 * <p>
 * Approach: Character counting per position. <br>
 * - For each index, count occurrences of that character across all strings. <br>
 * - Stop once any string ends or the counts diverge. <br>
 * <p>
 * Time Complexity: O(S) <br>
 * - S: total number of characters across all strings.
 * <p>
 * Space Complexity: O(m) <br>
 * - m: number of strings (used for counting per position).
 */
public class LeetCode0014_3 {

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
