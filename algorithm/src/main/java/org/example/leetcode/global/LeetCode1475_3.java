package org.example.leetcode.global;

/**
 * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop">LeetCode 1475: Final Prices With a Special Discount in a Shop</a>
 * <p>
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop. <br>
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all. <br>
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 * <p>
 * Difficulty: Easy
 * <p>
 * Approach: Brute force scan for next discount. <br>
 * - For each price, scan right until a smaller/equal price is found. <br>
 * - Apply the first such discount.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - Nested scan overprices.
 * <p>
 * Space Complexity: O(1) <br>
 * - Constant extra space.
 */
public class LeetCode1475_3 {

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int discount = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[i] >= prices[j]) {
                    discount = prices[j];
                    break;
                }
            }
            ans[i] = prices[i] - discount;
        }
        return ans;
    }

}
