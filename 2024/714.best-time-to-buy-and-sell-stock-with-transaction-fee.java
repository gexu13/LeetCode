/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
// dp
// 可以进行无数次交易 但每次卖股票后有一个手续费
// 这题和122.Best Time to Buy and Sell Stock II 一样的 只是多了个手续费
// 模板链接：https://labuladong.github.io/algo/di-er-zhan-a01c6/yong-dong--63ceb/yi-ge-fang-3b01b/
// dp[i][k][j]
// i 代表第几天
// k 代表的不是<已进行的交易次数> 而是 <最大交易次数的上限限制>
// j 0代表不持有股票 1代表持有股票
// 第i天，最多允许交易k次，不持有股票的最大利润
//      (前一天就不持有股票 今天继续不持有股票), (前一天持有股票, 今天售出 今天开始不持有股票)
// dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
// 第i天，最多允许交易k次，持有股票的最大利润
//         (前一天就持有股票, 今天继续持有股票), (前一天不持有股票 今天买入 今天开始持有股票）
// dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // k = +∞
        // 所以 k-1 和 k等价
        // 可以把 k 从 dp 数组中优化去除
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 不持有股票手里的最大利润
            // 卖股票的时候手收手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 持有股票手里的最大利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
// @lc code=end

