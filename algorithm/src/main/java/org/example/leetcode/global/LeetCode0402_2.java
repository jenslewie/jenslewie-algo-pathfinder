package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/remove-k-digits">...</a>
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
