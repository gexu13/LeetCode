/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 01背包的排列
        // 装满有多少种装法(组合数)
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // target 过大或过小都会导致无解
        if (sum < target || -sum > target) return 0; 
        if ((target + sum) % 2 == 1) return 0;
        int n = (target + sum) / 2;
        
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = n; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[n];
    }
}
// @lc code=end

