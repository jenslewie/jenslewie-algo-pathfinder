package org.example.leetcode.global;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop">LeetCode 1475: Final Prices With a Special Discount in a Shop</a>
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
