package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/longest-repeating-character-replacement">LeetCode 424: Longest Repeating Character Replacement</a>
 * <p>
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times. <br>
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with max frequency. <br>
 * - Track the most frequent character in the window. <br>
 * - Shrink when window size - maxFreq exceeds k.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each pointer moves at most n steps.
 * <p>
 * Space Complexity: O(1) <br>
 * - Fixed-size frequency array of 26 letters.
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
