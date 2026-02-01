package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">...</a>
 */
public class LeetCode0049_3 {

    /**
     * Time Complexity: O(n * k)
     * - n: number of strings in the input array
     * - k: maximum length of a string
     * - For each string: O(k) to count characters + O(26) to build key = O(k)
     * - Total: O(n * k)
     * <p>
     * Space Complexity: O(n * k)
     * - HashMap to store groups: O(n * k) for storing all strings
     * - Count array: O(26) = O(1)
     * - StringBuilder for key: O(26) = O(1) in worst case
     * - Overall: O(n * k)
     */
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
