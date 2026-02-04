package org.example.leetcode.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/VabMRr/">LCR 015: 找到字符串中所有字母异位词</a>
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。<br>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with count arrays. <br>
 * - Compare window counts with target counts. <br>
 * - Record indices where they match.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of s; each window shift is O(1) for 26 letters.
 * <p>
 * Space Complexity: O(1) <br>
 * - Two 26-length arrays.
 */
public class LeetCode0015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return result;
        }

        int[] window = new int[26];
        int[] need = new int[26];
        for (int i = 0; i < n; i++) {
            window[s.charAt(i) - 'a']++;
            need[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(window, need)) {
            result.add(0);
        }

        for (int i = n; i < m; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(window, need)) {
                result.add(i - n + 1);
            }
        }

        return result;
    }

}
