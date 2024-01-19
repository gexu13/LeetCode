/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // for (int i = 0; i < obstacleGrid.length; i++) {
        //     if (obstacleGrid[i][0] == 1) {
        //         break;
        //     }
        //     dp[i][0] = 1;
        // }
        // for (int j = 0; j < obstacleGrid[0].length; j++) {
        //     if (obstacleGrid[0][j] == 1) {
        //         break;
        //     }
        //     dp[0][j] = 1;
        // }

        // for (int i = 1; i < obstacleGrid.length; i++) {
        //     for (int j = 1; j < obstacleGrid[0].length; j++) {
        //         if (obstacleGrid[i][j] == 1) {
        //             continue;
        //         }
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        // return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

        int[] dp = new int[obstacleGrid[0].length];

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[j] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
// @lc code=end

