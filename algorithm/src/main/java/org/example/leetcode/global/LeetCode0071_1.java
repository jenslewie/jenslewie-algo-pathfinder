package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/simplify-path">LeetCode 71: Simplify Path</a>
 * <p>
 * Approach: Stack of path components. <br>
 * - Split by '/' and process components. <br>
 * - Use stack to handle ".." and ignore "." or empty segments.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: length of the path string.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores path components.
 */
public class LeetCode0071_1 {

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
