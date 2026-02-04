package org.example.leetcode.lcr;

/**
 * <a href="https://leetcode.cn/problems/8Zf90G/">LCR 036: 逆波兰表达式求值</a>
 * <p>
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。<br>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。<br>
 * 说明：<br>
 * 整数除法只保留整数部分。<br>
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * Difficulty: Medium
 * <p>
 * Approach: Array-based stack. <br>
 * - Push operands and apply operators to top two values. <br>
 * - Store results back on the stack.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of tokens; each token processed once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack holds operands.
 */
public class LCR0036 {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int top = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 1] = stack[top - 1] + stack[top];
                    top--;
                    break;
                case "-":
                    stack[top - 1] = stack[top - 1] - stack[top];
                    top--;
                    break;
                case "*":
                    stack[top - 1] = stack[top - 1] * stack[top];
                    top--;
                    break;
                case "/":
                    stack[top - 1] = stack[top - 1] / stack[top];
                    top--;
                    break;
                default:
                    stack[++top] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[top];
    }

}
