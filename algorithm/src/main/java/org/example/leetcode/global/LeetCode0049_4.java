package org.example.leetcode.global;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">...</a>
 */
public class LeetCode0049_4 {

    /**
     * Time Complexity: O(n * k * log(k))
     * - n: number of strings in the input array
     * - k: maximum length of a string
     * - Sorting each string takes O(k * log(k))
     * - Total: O(n * k * log(k))
     * <p>
     * Space Complexity: O(n * k)
     * - Map to store groups: O(n * k) for storing all strings
     * - Temporary char array for sorting: O(k)
     * - Overall: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })).values().stream().toList();
    }

}
