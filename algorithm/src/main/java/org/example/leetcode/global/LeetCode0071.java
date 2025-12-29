package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/simplify-path">...</a>
 */
public class LeetCode0071 {

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

    public String simplifyPath2(String path) {
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
