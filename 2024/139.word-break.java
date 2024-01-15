/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == 0) continue;

            for (String word : wordDict) {
                int hi = i + word.length();
                if (hi <= s.length() && word.equals(s.substring(i, hi))) {
                    dp[hi] = 1;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}
// @lc code=end

