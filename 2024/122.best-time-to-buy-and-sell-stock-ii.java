/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // greedy
        // 股票可以多次买卖
        // 收集正利润即可
        // int profit = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] - prices[i - 1] > 0) {
        //         profit += prices[i] - prices[i - 1];
        //     }
        // }
        // return profit;

        // dp
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
// @lc code=end

