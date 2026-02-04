package org.example.leetcode.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/">LCR 167: 招式拆解I</a>
 * <p>
 * 某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Sliding window with last-seen map. <br>
 * - Move left past duplicates. <br>
 * - Track maximum window length.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the string; each character processed once.
 * <p>
 * Space Complexity: O(min(m, n)) <br>
 * - m: character set size.
 */
public class LCR0167 {

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
