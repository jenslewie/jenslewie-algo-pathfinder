package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/">LeetCode LCR 167: Longest Substring Without Repeating Characters</a>
 * <p>
 * Approach: Sliding window with last-seen map. <br>
 - Move left past duplicates. <br>
 - Track maximum window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character processed once. <br>
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: character set size. <br>
 */
public class LeetCode0167 {

    public int dismantlingAction(String arr) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < arr.length()) {
            char c = arr.charAt(right);
            if (map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c) + 1;
            }
            map.put(c, right++);
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

}
