/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 */

// @lc code=start
// 同 486.predict the winner
class Solution {
    public boolean stoneGame(int[] piles) {
        Pair[][] dp = new Pair[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            for (int j = 0; j < piles.length; j++) {
                dp[i][j] = new Pair();
            }
        } 
        for (int i = 0; i < piles.length; i++) {
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        } 
        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;

                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        Pair pair = dp[0][piles.length - 1];
        return (pair.first - pair.second) > 0;
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

