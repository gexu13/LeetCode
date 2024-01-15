/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        if (dp[i + 1][j - 1] != 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                }
                if (dp[i][j] > maxLen) {
                    start = i;
                    maxLen = dp[i][j];
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
// @lc code=end

