/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }
        int target = total / 2;

        // 01背包 尽量装满这个背包
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]); 
            }
        }
        return total - dp[target] - dp[target];
    }
}
// @lc code=end

