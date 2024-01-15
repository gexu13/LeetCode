/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 完全背包排列问题
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 先遍历背包
        // 再遍历物品
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

