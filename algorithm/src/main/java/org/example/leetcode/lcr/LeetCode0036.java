package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/8Zf90G/">...</a>
 */
public class LeetCode0036 {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int top = -1;
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int a = stack[top--];
                switch (token) {
                    case "+":
                        stack[top] += a;
                        break;
                    case "-":
                        stack[top] -= a;
                        break;
                    case "*":
                        stack[top] *= a;
                        break;
                    case "/":
                        stack[top] /= a;
                        break;
                }
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }

}
