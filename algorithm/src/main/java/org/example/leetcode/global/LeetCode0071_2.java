package org.example.leetcode.global;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/simplify-path">LeetCode 71: Simplify Path</a>
 * <p>
 * Approach: Stack + front insertion. <br>
 * - Push valid path components to a stack. <br>
 * - Build the result by inserting components at the front.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - n: length of the path string; front insertion costs O(n) per component.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack stores path components.
 */
public class LeetCode0071_2 {

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
