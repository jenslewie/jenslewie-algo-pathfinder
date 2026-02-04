package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-k-digits">LeetCode 402: Remove K Digits</a>
 * <p>
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Deque as monotonic stack. <br>
 * - Maintain increasing digits; pop when a smaller digit appears. <br>
 * - Remove extra digits from the end if k remains.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of digits; each digit is added/removed at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Deque stores digits.
 */
public class LeetCode0402_2 {

    public String removeKdigits(String num, int k) {
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!queue.isEmpty() && queue.peekLast() > ch && k > 0) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(ch);
        }

        if (k > 0) {
            int remove = Math.min(k, queue.size());
            for (int i = 0; i < remove; i++) {
                queue.pollLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.pollFirst();
            if (sb.isEmpty() && ch == '0') {
                continue;
            }
            sb.append(ch);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

}
