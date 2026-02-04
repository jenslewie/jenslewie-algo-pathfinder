package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/simplify-path">LeetCode 71: Simplify Path</a>
 * <p>
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path. <br>
 * The rules of a Unix-style file system are as follows: <br>
 * The simplified canonical path should follow these rules: <br>
 * Return the simplified canonical path.
 * <p>
 * Difficulty: Medium
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
