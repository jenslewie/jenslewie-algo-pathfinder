package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/MPnaiL/description/">LeetCode LCR 014: Permutation in String</a>
 * <p>
 * Approach: Sliding window with count array. <br>
 - Track frequency deltas for s1 and window in s2. <br>
 - Adjust left when a count exceeds target.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s2; single pass with two pointers.
 * <p>
 * Space Complexity: O(1) <br>
 * - Fixed-size array of 26 counts.
 */
public class LeetCode0014_1 {

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            int index = s2.charAt(right) - 'a';
            cnt[index]++;
            while (cnt[index] > 0) {
                cnt[s2.charAt(left++) - 'a']--;
            }
            if (right - left + 1 == m) {
                return true;
            }
        }
        return false;
    }
}