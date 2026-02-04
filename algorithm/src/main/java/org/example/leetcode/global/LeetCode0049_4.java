package org.example.leetcode.global;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">LeetCode 49: Group Anagrams</a>
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Stream grouping with sorted-string key. <br>
 * - Sort characters of each string in a stream pipeline. <br>
 * - Group by the sorted key.
 * <p>
 * Time Complexity: O(n * k * log(k)) <br>
 * - n: number of strings; k: max string length.
 * <p>
 * Space Complexity: O(n * k) <br>
 * - Store grouped strings and sorted keys.
 */
public class LeetCode0049_4 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })).values().stream().toList();
    }

}
