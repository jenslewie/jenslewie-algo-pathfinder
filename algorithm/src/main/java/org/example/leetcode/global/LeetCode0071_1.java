package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/simplify-path">...</a>
 */
public class LeetCode0071_1 {

    /**
     * Time Complexity: O(n)
     * - n: length of the path string
     * - We process each component once
     * <p>
     * Space Complexity: O(n)
     * - Deque can store up to n components in the worst case
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String str : path.split("/")) {
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                continue;
            }
            if (!str.isEmpty() && !".".equals(str)) {
                stack.offer(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollFirst());
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}