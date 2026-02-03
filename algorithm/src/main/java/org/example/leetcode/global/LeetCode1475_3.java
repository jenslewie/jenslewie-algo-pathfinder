package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop">LeetCode 1475: Final Prices With a Special Discount in a Shop</a>
 * <p>
 * Approach: Brute force scan for next discount. <br>
 * - For each price, scan right until a smaller/equal price is found. <br>
 * - Apply the first such discount.
 * <p>
 * Time Complexity: O(n^2) <br>
 * - Nested scan over prices.
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
