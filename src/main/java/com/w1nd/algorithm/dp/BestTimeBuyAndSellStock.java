package com.w1nd.algorithm.dp;

/**
 * 121. 买卖股票的最佳时机
 */
public class BestTimeBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0, cost = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i ++) {
                cost = Math.min(cost, prices[i]);
                profit = Math.max(profit, prices[i] - cost);
            }
            return profit;
        }
    }
}
