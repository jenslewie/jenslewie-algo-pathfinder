package org.example.leetcode.global;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">LeetCode 3: Longest Substring Without Repeating Characters</a>
 * <p>
 * Approach: Sliding window with a HashSet. <br>
 * - Expand right pointer and add characters to the set. <br>
 * - When a duplicate appears, shrink from the left until it is removed.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character is added/removed at most once.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: size of the character set; set stores at most min(m, n) entries.
 */
public class LeetCode0003_2 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right++);
            boolean notExists = set.add(c);
            if (!notExists) {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left++));
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
