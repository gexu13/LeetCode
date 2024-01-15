/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        char[] sArray = s.toCharArray();
        if (sArray[0] == '0') {
            return 0;
        }
        if (sArray.length == 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;
        int count = 0;

        for (int i = 1; i < sArray.length; i++) {
            count = 0;
            // 单独作为一位数
            int digit = sArray[i] - '0';
            if (digit != 0) {
                count = prev1;
            }

            // 和前一位数共同组成两位数
            int twoDigits = Integer.valueOf(s.substring(i - 1, i + 1));
            if (twoDigits >= 10 && twoDigits <= 26) {
                count += prev2;
            } 
            // else if (twoDigits == 0) {
            //     return 0;
            // }
            prev2 = prev1;
            prev1 = count;
        }
        return count;
    }
}
// @lc code=end

