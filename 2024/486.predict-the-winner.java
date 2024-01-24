/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
// dp博弈问题
class Solution {
    public boolean predictTheWinner(int[] nums) {
        // dp[i][j].first 表示在nums[i, j]里先选能获得的最大分数
        // dp[i][j].second 表示在nums[i, j]里后选能获得的最大分数
        Pair[][] dp = new Pair[nums.length][nums.length];
        // 初始化
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = new Pair();
            }
        }
        // 初始化
        for (int i = 0; i < nums.length; i++) {
            dp[i][i].first = nums[i];
            dp[i][i].second = 0;
        }
        // 从dp数组的推导可以得出 
        // 递推顺序是从下往上 从左往右
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                // case1: 在nums[i, j]中，如果player先手选择数组最左边的数字，
                // 那剩余可供选择的数组范围为nums[i + 1, j]
                // 那么在nums[i + 1, j]中 这个player只能作为后手挑选
                int left = nums[i] + dp[i + 1][j].second;
                // case2: 在nums[i, j]中，如果player先手选择数组最右边的数字，
                // 那剩余可供选择的数组范围为nums[i, j - 1]
                // 那么在nums[i, j - 1]中 这个player只能作为后手挑选
                int right = nums[j] + dp[i][j - 1].second;

                // left和right选大的那个
                if (left > right) {
                    // 如果在nums[i, j]中，player先手选nums[i]得分比较高
                    dp[i][j].first = left;
                    // 另外一名player就可以在nums[i + 1, j]中先手选择
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    // 同理，如果在nums[i, j]中，player先手选nums[j]得分比较高
                    dp[i][j].first = right;
                    // 另外一名player就可以在nums[i, j - 1]中先手选择
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        // 打印dp数组
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums.length; j++) {
        //         System.out.print("(" + dp[i][j].first + "," + dp[i][j].second + ")" + " ");
        //     }
        //     System.out.println();
        // }
        Pair pair = dp[0][nums.length - 1];
        return (pair.first - pair.second) >= 0;
    }
}

class Pair {
    int first;
    int second;

    public Pair() {
        this.first = 0;
        this.second = 0;
    }
}
// @lc code=end

