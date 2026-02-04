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
 * Approach: Frequency-map key. <br>
 * - Count character frequencies for each string. <br>
 * - Use the frequency map as a grouping key.
 * <p>
 * Time Complexity: O(n * k) <br>
 * - n: number of strings; k: max string length.
 * <p>
 * Space Complexity: O(n * k) <br>
 * - Store grouped strings and per-string frequency maps.
 */
public class LeetCode0049_1 {

    public List<List<String>> groupAnagrams(String[] strs) {
        var ans = new HashMap<HashMap<Character, Integer>, List<String>>();
        for (String str : strs) {
            var key = new HashMap<Character, Integer>();
            for (char c : str.toCharArray()) {
                key.put(c, key.getOrDefault(c, 0) + 1);
            }
            var list = ans.getOrDefault(key, new ArrayList<>());
            list.add(str);
            ans.put(key, list);
        }
        return ans.values().stream().toList();
    }

}
