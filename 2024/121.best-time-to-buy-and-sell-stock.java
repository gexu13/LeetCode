/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
// dp
// 只能进行一次交易
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
    // 与这道题而言 k = 1
    // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    // dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) 
    //             = max(dp[i-1][1][1], -prices[i])
    // 对于k - 1，dp[i - 1][k - 1][0] = dp[i - 1][0][0] = 0
    // 剩余的k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
    // 可以进行进一步化简去掉所有 k：
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
// @lc code=end

