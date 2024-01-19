/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // 题目说的只是操作word1 增删替换 变为word2
        // 实际上word1 和 word2都可以操作 最终使得word1和word2相同即可

        // insert word1 相当于delete word2（关键）
        // 例如 word1 = a， word2 = ad
        // word1 insert d 变成 ad
        // 相当于 word2 删除d 变成 a
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[][] dp = new int[word1Array.length + 1][word2Array.length + 1];

        for (int i = 1; i <= word1Array.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2Array.length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1Array.length; i++) {
            for (int j = 1; j <= word2Array.length; j++) {
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //                      删除word1       删除word2（相当于insert word1）   替换word1   
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[word1Array.length][word2Array.length];
    }
}
// @lc code=end

