package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/simplify-path">...</a>
 */
public class LeetCode0071_2 {

    /**
     * Time Complexity: O(n^2)
     * - n: length of the path string
     * - StringBuilder.insert(0, ...) takes O(n) time for each insertion
     * <p>
     * Space Complexity: O(n)
     * - Stack can store up to n components in the worst case
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String str : path.split("/")) {
            if (str.isEmpty() || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }
        return res.isEmpty() ? "/" : res.toString();
    }
}