package org.example.leetcode.global;

/**
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 */
public class LeetCode0424 {

    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int left = 0, right = 0;
        int[] windowCharCount = new int[26];
        int windowMaxCount = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            windowCharCount[c - 'A']++;
            windowMaxCount = Math.max(windowMaxCount, windowCharCount[c - 'A']);
            while (right - left - windowMaxCount > k) {
                char d = s.charAt(left++);
                windowCharCount[d - 'A']--;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}
