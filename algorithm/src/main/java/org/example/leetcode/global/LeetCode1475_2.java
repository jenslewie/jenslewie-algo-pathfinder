package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop">LeetCode 1475: Final Prices With a Special Discount in a Shop</a>
 * <p>
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop. <br>
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all. <br>
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 * <p>
 * Difficulty: Easy
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
