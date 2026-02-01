package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">...</a>
 */
public class LeetCode0049_1 {

    /**
     * Time Complexity: O(n * k)
     * - n: number of strings in the input array
     * - k: maximum length of a string
     * - We iterate through each string once and count character frequencies
     * <p>
     * Space Complexity: O(n * k)
     * - HashMap to store groups: O(n * k) for storing all strings
     * - Temporary frequency map for each string: O(26) = O(1) for lowercase letters
     * - Overall: O(n * k)
     */
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
