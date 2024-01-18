/*
 * @lc app=leetcode id=1871 lang=java
 *
 * [1871] Jump Game VII
 */

// @lc code=start
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // dp能过
        // 时间复杂度O(n * (maxJump - minJump)) 效率不高
        if (s.charAt(s.length() - 1) != '0') return false;
        char[] sArray = s.toCharArray();
        int[] dp = new int[sArray.length];
        dp[0] = 1;
        for (int i = minJump; i <= maxJump; i++) {
            if (sArray[i] == '0') {
                dp[i] = 1;
            }
        }
        for (int i = maxJump + 1; i < sArray.length; i++) {
            if (sArray[i] == '1') continue;
            for (int j = minJump; j <= maxJump; j++) {
                if (dp[i - j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[sArray.length - 1] == 1;
    }
}
// @lc code=end

