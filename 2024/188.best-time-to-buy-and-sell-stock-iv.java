/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
// dp
// k = K 最大交易次数的上限为K
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
    public int maxProfit(int k, int[] prices) {
        // dp[i][k][j]
        // i 代表第几天
        // k 代表的不是<已进行的交易次数> 而是 <最大交易次数的上限限制>
        // j 0代表不持有股票 1代表持有股票
        int[][][] dp = new int[prices.length][k + 1][2];
        int K = k;
        // 初始化
        // 第0天 最大交易限制次数为k的时候 持有股票手上的最大利润
        for (k = 1; k <= K; k++) {
            dp[0][k][1] = -prices[0];
        }
        
        for (int i = 1; i < prices.length; i++) {
            for (k = 1; k <= K; k++) {
                // 不持有股票的最大利润
                //                      前一天就不持有股票      今天开始不持有股票
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                // 持有股票的最大利润
                //                      前一天就持有股票       今天开始持有股票
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][K][0];
    }
}
// @lc code=end

