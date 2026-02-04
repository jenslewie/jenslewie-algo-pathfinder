package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">LeetCode 49: Group Anagrams</a>
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Fixed-length count signature. <br>
 * - Build a compact key from 26 lowercase character counts. <br>
 * - Group strings by that signature.
 * <p>
 * Time Complexity: O(n * k) <br>
 * - n: number of strings; k: max string length.
 * <p>
 * Space Complexity: O(n * k) <br>
 * - Store grouped strings and generated keys.
 */
public class LeetCode0049_3 {

    public List<List<String>> groupAnagrams(String[] strs) {
        var ans = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            var list = ans.getOrDefault(key, new ArrayList<>());
            list.add(str);
            ans.put(key, list);
        }
        return new ArrayList<>(ans.values());
    }

}
