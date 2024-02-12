/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // '.' 匹配任意单个字符
        // '*' 匹配零个或多个前面的那一个字符
        // 也就是说，'*'的作用可以是
        // 1. 把'*'前面的字符消掉
        // 2. '*'当作不存在
        // 3. '*'可以当作多个前面的字符

        int[][] dp = new int[s.length() + 1][p.length() + 1];
        dp[0][0] = 1;

        // 初始化第一行
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // 如果当前字符相等，或者p的当前字符为'.'
                // 那么当前的匹配结果取决于前面的匹配结果
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                // 如果p的当前字符为'*'
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j-1] | dp[i][j-2]; // '*'当作不存在 | '*'把前面的字符消掉
                    // 如果s的当前字符和p的前一个字符相等，或者p的前一个字符为'.'
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i-1][j]; // '*'可以当作多个前面的字符
                    }
                }
            }
        }
        return dp[s.length()][p.length()] == 1;
    }
}
// @lc code=end

