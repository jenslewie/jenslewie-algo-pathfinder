package org.example.leetcode.global;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop">...</a>
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
