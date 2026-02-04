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
 * Approach: Monotonic stack of indices. <br>
 - Find next smaller or equal price to apply discount. <br>
 - Update prices when a discount is found.
 * <p>
 * Time Complexity: O(n) <br>
 * - n: number of prices; each index pushed/popped once.
 * <p>
 * Space Complexity: O(n) <br>
 * - Stack of indices.
 */
public class LeetCode1475_1 {

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

}
