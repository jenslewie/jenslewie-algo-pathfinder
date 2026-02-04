package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/group-anagrams">LeetCode 49: Group Anagrams</a>
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sorted-string key. <br>
 * - Sort characters of each string. <br>
 * - Use the sorted string as the grouping key.
 * <p>
 * Time Complexity: O(n * k * log(k)) <br>
 * - n: number of strings; k: max string length.
 * <p>
 * Space Complexity: O(n * k) <br>
 * - Store grouped strings and sorted keys.
 */
public class LeetCode0049_2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        var ans = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            var list = ans.getOrDefault(key, new ArrayList<>());
            list.add(str);
            ans.put(key, list);
        }
        return ans.values().stream().toList();
    }

}
