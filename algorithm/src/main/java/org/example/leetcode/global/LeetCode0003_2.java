package org.example.leetcode.global;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class LeetCode0003_2 {

    /**
     * Use set to record if character has already existed
     * Time Complexity: O(n)
     * - n: length of the string
     * - Each character is visited at most twice (once by right pointer, once by left pointer)
     * <p>
     * Space Complexity: O(min(m,n))
     * - m: size of the charset (number of distinct characters in the string)
     * - Set stores at most min(m,n) characters
     */
    public int lengthOfLongestSubstring(String s) {
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
}