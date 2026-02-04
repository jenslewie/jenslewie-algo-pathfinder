package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop">LeetCode 1475: Final Prices With a Special Discount in a Shop</a>
 * <p>
 * Approach: Brute force scan for next discount. <br>
 - For each price, scan right until a smaller/equal price is found.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - Nested scan over prices.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode1475_2 {

    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

}
