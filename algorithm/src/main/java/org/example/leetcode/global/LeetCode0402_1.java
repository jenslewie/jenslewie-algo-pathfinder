package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/remove-k-digits">LeetCode 402: Remove K Digits</a>
 * <p>
 * Approach: Monotonic stack. <br>
 * - Remove larger previous digits while k remains. <br>
 * - Strip leading zeros and handle remaining removals.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of digits; each digit is pushed/popped at most once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack holds digits.
 */
public class LeetCode0402_1 {

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && c == '0') {
                continue;
            }
            stack.push(c);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
