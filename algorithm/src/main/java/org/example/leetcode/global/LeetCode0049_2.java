package org.example.leetcode.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">...</a>
 */
public class LeetCode0049_2 {

    /**
     * Time Complexity: O(n * k * log(k))
     * - n: number of strings in the input array
     * - k: maximum length of a string
     * - Sorting each string takes O(k * log(k))
     * - Total: O(n * k * log(k))
     * <p>
     * Space Complexity: O(n * k)
     * - HashMap to store groups: O(n * k) for storing all strings
     * - Temporary char array for sorting: O(k)
     * - Overall: O(n * k)
     */
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
