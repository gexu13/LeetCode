/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
// dp
// 可以进行无数次交易 但有交易冷冻期 卖出股票后要等一天才能继续买入股票
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
    public int maxProfit(int[] prices) {
        /*****************************************************************/
        // 模板写法（没有完全理解 i - 2 ）
        // 这道题也是没有最大交易次数 k 的限制
        // 冷冻期的含义就是：
        // 第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
        if (prices.length == 1) return 0;
        int[][] dp = new int[prices.length][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 初始化
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], 0 - prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 对于dp[i - 2][0]的解释
            // 每次 sell 之后要等一天才能继续交易
            // 第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1

            // 第 i 天要买入：
            // 如果 i-1 天是卖出状态，则第i天的状态不能从i-1天转移 只能看第 i-2 天的状态
            // 如果 i-1 天不是卖出状态，那 i-1 天只能是冷冻期或者是度过冷冻期的状态
            // 冷冻期或者是度过冷冻期的状态 不持有股票的最大利润和它前一天不持有股票的最大利润是一样的
            // 所以无论第 i-1 天是不是卖出状态，第 i 天的状态都可以从第 i-2 天转移得到
            // 所以这里是dp[i - 2][0]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];



        /*****************************************************************/
        // 四种状态的写法
        // int[][] dp = new int[prices.length][4];
        // // 买入状态
        // dp[0][0] = -prices[0];
        // // 卖出状态
        // dp[0][1] = 0;
        // // cool down
        // dp[0][2] = 0;
        // // out of cool down
        // dp[0][3] = 0;

        // for (int i = 1; i < prices.length; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3] - prices[i]));
        //     dp[i][1] = dp[i - 1][0] + prices[i];
        //     dp[i][2] = dp[i - 1][1];
        //     dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
        // }
        // return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2],dp[prices.length - 1][3]));




    }
}



// @lc code=end

